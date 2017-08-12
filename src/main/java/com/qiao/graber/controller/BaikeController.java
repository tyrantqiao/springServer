package com.qiao.graber.controller;

import com.qiao.graber.domain.Baike;
import com.qiao.graber.repository.BaikeRepository;
import com.qiao.graber.service.BaikeService;
import com.sun.media.jfxmedia.logging.Logger;
import org.hibernate.validator.constraints.URL;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author qiao
 * email tyrantqiao@icloud.com
 */
@RestController
@RequestMapping("/baike")
public class BaikeController {
    private BaikeRepository baikeRepository;
    private BaikeService service;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BaikeController.class);

    @Autowired
    private void setBaikeRepository(BaikeRepository baikeRepository) {
        this.baikeRepository = baikeRepository;
    }

    @Autowired
    public void setService(BaikeService service) {
        this.service = service;
    }

    @RequestMapping(value = "/lists", method = RequestMethod.GET)
    public List<Baike> getBaikeList() {
//        Logger.logMsg(Logger.INFO, "emmmmmmmmm" + baikeRepository.findAll());
        return baikeRepository.findAll();
    }


    @GetMapping("/get/id/{id}")
    public Baike getBaikeById(@PathVariable("id") Integer id) {
        return baikeRepository.findOne(id);
    }

    /**
     * @param baike baike's object
     * @return Baike
     * add a baike.
     * /@valid  verify the object is abiding by the constraint.
     */
    @PostMapping(value = "/add")
    public Baike addBaike(@Valid Baike baike, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            logger.error(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        return baikeRepository.save(baike);
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Baike updateBaike(@PathVariable("id") Integer id,
                             @Valid Baike baike, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        baike.setId(id);
        return baikeRepository.save(baike);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBaike(@PathVariable("id") Integer id) {
        logger.info("delete the element:" + id);
        baikeRepository.delete(id);
    }

    @GetMapping("/get/title/{title}")
    public Baike getBaikeByTitle(@PathVariable("title") String title) {
        return baikeRepository.getBaikeByTitle(title);
    }

    @PostMapping("/doSomething")
    public String doSomething() {
        return "doSomething";
    }
}
