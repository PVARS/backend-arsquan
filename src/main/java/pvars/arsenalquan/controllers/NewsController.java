package pvars.arsenalquan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pvars.arsenalquan.message.ResponseMessage;
import pvars.arsenalquan.message.request.SearchForm;
import pvars.arsenalquan.models.News;
import pvars.arsenalquan.repositories.NewsRepository;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NewsController {

    @Autowired
    NewsRepository newsRepository;

    @PostMapping("/save")
    public ResponseEntity<?> add(@Valid @RequestBody News news) throws IOException {
        newsRepository.save(news);
        return new ResponseEntity<>(new ResponseMessage("Lưu thành công"), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<News>> getAll() throws IOException {
        List<News> news = newsRepository.findAll();
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping("/getSortDateASC")
    public ResponseEntity<List<News>> getSortDateASC() throws IOException {
        List<News> news = newsRepository.sortDateASC();
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping("/getSortDateDESC")
    public ResponseEntity<List<News>> getSortDateDESC() throws IOException {
        List<News> news = newsRepository.sortDateDESC();
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showEditForm(@PathVariable Long id) {
        News news = newsRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Không tìm thấy bài viết này"));
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Long> delete(@RequestBody Long id) {
        newsRepository.deleteById(id);
        return new ResponseEntity(new ResponseMessage("Xoá thành công"), HttpStatus.OK);
    }

    @PostMapping("/deteteNews")
    public ResponseEntity<?> deleteByNews(@RequestBody News News) {
        newsRepository.deleteById(News.getId());
        return new ResponseEntity(new ResponseMessage("Xoá thành công"), HttpStatus.OK);
    }

    @PostMapping("/searchAll")
    public ResponseEntity<?> showEditForm(@RequestBody SearchForm searchString) {
        List<News> news = newsRepository.findAll();
        news = news.stream().filter(
                item ->item.getId().toString().contains(searchString.getSearchString())
                        || item.getTitle().contains(searchString.getSearchString())
                        || item.getShortDesciption().contains(searchString.getSearchString())
                        || item.getCreateDate().toString().contains(searchString.getSearchString())
                        || item.getUpdateDate().toString().contains(searchString.getSearchString())
                        || item.getCreateBy().toString().contains(searchString.getSearchString())
                        || item.getUpdateBy().toString().contains(searchString.getSearchString())
        ).collect(Collectors.toList());
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
}
