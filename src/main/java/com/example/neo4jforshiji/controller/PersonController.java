package com.example.neo4jforshiji.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.neo4jforshiji.Service.PersonService;
import com.example.neo4jforshiji.entitiy.Person;
import com.example.neo4jforshiji.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/neo4j")
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/addPerson",method = RequestMethod.POST)
    public JSONObject addPerson(HttpServletRequest httpServletRequest) {
        JSONObject jsonObject = new JSONObject();
        Long id = Long.valueOf(httpServletRequest.getParameter("id"));
        String name = httpServletRequest.getParameter("name");
        String label = httpServletRequest.getParameter("label");
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setLabel(label);
        if(personService.addPerson(person)) {
            jsonObject.put(Consts.CODE, "1");
            jsonObject.put(Consts.MSG, "添加成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, "0");
        jsonObject.put(Consts.MSG, "添加失败");
        return jsonObject;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Person> findAll() {
        return personService.findAll();
    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public Person findByName(HttpServletRequest httpServletRequest) {
        String name = httpServletRequest.getParameter("name");
        return personService.findByName(name);
    }

    @RequestMapping(value = "/deleteByName", method = RequestMethod.POST)
    public JSONObject deleteByName(HttpServletRequest httpServletRequest) {
        JSONObject jsonObject = new JSONObject();
        String name = httpServletRequest.getParameter("name");
        if(personService.deleteByName(name)) {
            jsonObject.put(Consts.CODE, "1");
            jsonObject.put(Consts.MSG, "删除成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, "0");
        jsonObject.put(Consts.MSG, "删除失败");
        return jsonObject;
    }

    @RequestMapping(value = "/createRelation" ,method = RequestMethod.POST)
    public JSONObject createRelation(HttpServletRequest httpServletRequest) {
        JSONObject jsonObject = new JSONObject();
        String from = httpServletRequest.getParameter("from");
        String to = httpServletRequest.getParameter("to");
        String relation = httpServletRequest.getParameter("relation");
        if(personService.createRelation(from, to, relation)) {
            jsonObject.put(Consts.CODE, "1");
            jsonObject.put(Consts.MSG, "创建成功");
        }
        jsonObject.put(Consts.CODE, "0");
        jsonObject.put(Consts.MSG, "创建失败");
        return jsonObject;
    }
}
