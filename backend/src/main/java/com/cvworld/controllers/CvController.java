package com.cvworld.controllers;
import com.cvworld.dao.CvRepo;
import com.itextpdf.text.Image;

import com.cvworld.model.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import javafx.embed.swing.SwingFXUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class CvController {
    private PushbuttonField ad;
    @Autowired private CvRepo cvRepo;

    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
    {
        File convFile = new File( multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }
    @GetMapping("/cv")
    public String getcvpage(Model model, HttpSession session) {

//        User user = (User) session.getAttribute("user");
//        if (user == null) {
//            model.addAttribute("user", new User());
//        } else {
//            model.addAttribute(user);
//        }
        model.addAttribute("user",new User());
        //model.addAttribute("image",new Image());
        model.addAttribute("university",new University());
        model.addAttribute("hobby",new Hobby());
        model.addAttribute("expirience",new Experience());


        return "cv-builder";
    }
    @PostMapping("/docv")
    public String userLogin(@ModelAttribute("user") User
            user, @ModelAttribute("hobby")Hobby hobby, @ModelAttribute("expirience")Experience experience,
                            @ModelAttribute("university")University university, @RequestParam("image") MultipartFile files, RedirectAttributes redirectAttr,HttpSession session, Model model) {
        String a=null;
        try {
            //Create PdfReader instance.
            PdfReader pdfReader = new PdfReader("D:\\odftemplate9.pdf");
            //Get the number of pages in pdf.

            int pages = pdfReader.getNumberOfPages();
                if(session.getAttribute("user")!=null){
                    User user1= (User) session.getAttribute("user");
                    System.out.println("user is here");
                    new File("D:\\" + user1.getEmail()).mkdirs();
                    int randomNum = ThreadLocalRandom.current().nextInt(0, 1000);


                    a="D:\\"+user1.getEmail() +"\\"+"m1"+randomNum+".pdf";
                }else {
                    a="D:\\ModifiedTestFile.pdf";
                }

                    PdfStamper pdfStamper =
                    new PdfStamper(pdfReader,
                            new FileOutputStream(a));


            AcroFields fields = pdfStamper.getAcroFields();
            //Iterate the pdf through pages.
//            for (int i = 1; i <= pages; i++) {
//                //Extract the page content using PdfTextExtractor.
//                String pageContent =
//                        PdfTextExtractor.getTextFromPage(pdfReader, i);
//                PdfContentByte pageContentByte =
//                        pdfStamper.getOverContent(i);
//            }
            if(files!=null) {

                String aa = files.getOriginalFilename();
                try {
                    files.transferTo(new File("D:\\" + files.getOriginalFilename()));
                } catch (IllegalStateException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

//            BufferedImage img = null;
//


                Image img1 = Image.getInstance("D:\\" + aa);
                PdfContentByte content = pdfStamper.getUnderContent(1);

                if (img1 != null) {
                    //
//                    img1.scaleAbsoluteHeight(50);
//                    img1.scaleAbsoluteWidth((img1.getWidth() * 50) / img1.getHeight());
//                  //
//                    //document.top(150f);
//
//                  // img1.setAbsolutePosition(pdfReader.getLeft(), reader.getPageSize(i).getBottom());
//                    img1.setAbsolutePosition(0,0);
//                    content.addImage(img1);
                    PushbuttonField ad = fields.getNewPushbuttonFromField("bus");
                    ad.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
                    ad.setProportionalIcon(true);
                    ad.setImage(img1);
                    fields.replacePushbuttonField("bus", ad.getField());

                }
            }

            if(user.getBirthDate()!=null) {
                //content.addImage(img1);
                DateFormat dateFormat = new SimpleDateFormat("MM dd yyyy");

                String s = dateFormat.format(user.getBirthDate());
                fields.setField("birthdate",s);
            }

         // System.out.println(  );

            fields.setField("firstname",user.getFirstName());
            fields.setField("lastname",user.getLastName());
            fields.setField("address",user.getGithub());
            fields.setField("linkedin",user.getLinkedIn());
            fields.setField("phonenumber",user.getPhoneNumber());
            fields.setField("objective",user.getObjective());
            fields.setField("wexp",experience.getExplained());
            fields.setField("hobby",hobby.getName());

            fields.setField("university",university.getDegree());
            CvResources x =new CvResources();
            x.setAddress(a);
            cvRepo.save(x);

            pdfStamper.close();
            pdfReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}






