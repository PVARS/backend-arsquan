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

    @PostMapping("/searchAllColumn")
    public ResponseEntity<?> showEditForm(@RequestBody SearchForm searchString) {
        List<News> news = newsRepository.findAll();
        news = news.stream().filter(
                item ->item.getId().toString().contains(searchString.getSearchString())
                        || item.getTieuDe().contains(searchString.getSearchString())
                        || item.getMoTaNgan().contains(searchString.getSearchString())
                        || item.getNgayTao().toString().contains(searchString.getSearchString())
                        || item.getNgayThayDoi().toString().contains(searchString.getSearchString())
                        || item.getTaoBoi().toString().contains(searchString.getSearchString())
                        || item.getThayDoiBoi().toString().contains(searchString.getSearchString())
        ).collect(Collectors.toList());
        return new ResponseEntity<>(news, HttpStatus.OK);
    }
}
