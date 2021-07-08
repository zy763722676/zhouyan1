package com.zy.testmyjpa.controller;/*
 * @Author zhouyan
 **/

import com.zy.testmyjpa.dao.UserDao;
import com.zy.testmyjpa.entity.User;
import com.zy.testmyjpa.entity.pojo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping(value="find/{username}")
    @ResponseBody
    public ResultBean findByUsername(@PathVariable("username") String username){
        List<User> user = userDao.findByUsername(username);
       // System.out.println(user);
        return new ResultBean(user.get(0));
    }
    @RequestMapping(value="findkey/{keyword}")
    @ResponseBody
    public ResultBean findByUsernameLike(@PathVariable("keyword") String keyword){
        List<User> users = userDao.findByUsernameLike("%"+keyword+"%");
        return new ResultBean(users);
    }
    @RequestMapping(value="findkeypage/{keyword}")
    @ResponseBody
    public ResultBean findByUsernameLikePage(@PathVariable("keyword") String keyword,  @RequestParam(value = "pageindex", defaultValue = "0")int pageindex,
                                           @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        Pageable of = PageRequest.of(pageindex, pageSize);
        Specification<User>  specification=new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("username"),"%"+keyword+"%");
            }
        };
        Page<User> userPage = userDao.findAll(specification, of);
        return new ResultBean(userPage);
    }
    @RequestMapping(value="findpage/{keyword}")
    @ResponseBody
    public ResultBean findByUsernamePage(@PathVariable("keyword") String keyword,  @RequestParam(value = "pageindex", defaultValue = "0")int pageindex,
                                             @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        Pageable of = PageRequest.of(pageindex, pageSize);
        Specification<User>  specification=new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                User user=new User();
                user.setType(0);
                user.setUsername("min");
                Predicate p1 = cb.like(root.get("username").as(String.class), "%"+keyword+"%");
                Predicate p2 = cb.equal(root.get("type").as(Integer.class), user.getType());
                Predicate p3 = cb.like(root.get("name").as(String.class), "%"+user.getUsername()+"%");
                //把Predicate应用到CriteriaQuery中去,因为还可以给CriteriaQuery添加其他的功能，比如排序、分组啥的
                query.where(cb.and(p3,p1,p2));
                //添加排序的功能(顺序)
                query.orderBy(cb.asc(root.get("id").as(Integer.class)));

                //查找username中有传进来的keyword关键字的，name中有min关键字的，类型是0的顺序，分页排序。
                return query.getRestriction();
            }
        };
        Page<User> userPage = userDao.findAll(specification, of);
        return new ResultBean(userPage);
    }
    @RequestMapping(value="findpage2/{keyword}")
    @ResponseBody
    public ResultBean findByPage(@PathVariable("keyword") String keyword,  @RequestParam(value = "pageindex", defaultValue = "0")int pageindex,
                                         @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        Pageable of = PageRequest.of(pageindex, pageSize);
        Specification<User>  specification=new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                User user=new User();
                user.setType(0);
                user.setUsername("min");
                Predicate p1 = cb.like(root.get("username").as(String.class), "%"+keyword+"%");
                Predicate p2 = cb.equal(root.get("type").as(Integer.class), user.getType());
                Predicate p3 = cb.like(root.get("name").as(String.class), "%"+user.getUsername()+"%");
                //把Predicate应用到CriteriaQuery中去,因为还可以给CriteriaQuery添加其他的功能，比如排序、分组啥的
                query.where(cb.and(p3,p1,p2));
                //添加排序的功能(顺序)
                query.orderBy(cb.asc(root.get("id").as(Integer.class)));

                //查找username中有传进来的keyword关键字的，name中有min关键字的，类型是0的顺序，分页排序。
                return query.getRestriction();
            }
        };
        Page<User> userPage = userDao.findAll(specification, of);
        return new ResultBean(userPage);
    }

}
