package ru.dnevnik.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dnevnik.aop.repository.BookRepository;

/**
 * @author Kurbatov Gennadii
 * @since 01.11.15
 */
@RestController("/")
public class CommonController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(name = "/put", method = RequestMethod.POST)
    public ResponseEntity<String> putBook(@RequestParam("id") Integer id, @RequestParam("name") String name) {
        bookRepository.put(id, name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(name = "/get", method = RequestMethod.DELETE)
    public ResponseEntity<String> getBook(@RequestParam("id") Integer id) {
        if (bookRepository.get(id) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(name = "/find", method = RequestMethod.GET)
    public ResponseEntity<String> findBook(@RequestParam("id") Integer id) {
        if (bookRepository.findOne(id) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
