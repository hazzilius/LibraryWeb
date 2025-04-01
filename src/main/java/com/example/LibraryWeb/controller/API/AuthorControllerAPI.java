package com.example.LibraryWeb.controller.API;

import com.example.LibraryWeb.dto.AuthorDto;
import com.example.LibraryWeb.model.Author;
import com.example.LibraryWeb.response.BaseResponse;
import com.example.LibraryWeb.response.DataResponse;
import com.example.LibraryWeb.response.ListResponse;
import com.example.LibraryWeb.service.AuthorService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/author")
public class AuthorControllerAPI {
    private final AuthorService authorService;

    public AuthorControllerAPI(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public ResponseEntity<ListResponse<Author>> getAll(
            @RequestParam(defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(defaultValue = "20") @Min(1) @Max(100) Integer limit
    ){
        try {
            return ResponseEntity.ok(
                    new ListResponse<>(true, "Список авторов", authorService.findAll(offset, limit).getContent())
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    new ListResponse<>(false, "Авторы не найдены!", null)
            );
        }
    }

    @GetMapping
    public ResponseEntity<DataResponse<Author>> byId(@RequestParam Long id){
        try {
            return ResponseEntity.ok(
                    new DataResponse<>(true, "Найден следующий автор", authorService.findById(id))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    new DataResponse<>(false, "Автор не найден!", null)
            );
        }
    }

    @GetMapping("/search")
    public ResponseEntity<ListResponse<Author>> findByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset,
            @RequestParam(defaultValue = "20") @Min(1) @Max(100) Integer limit){
        try {
            return ResponseEntity.ok(
                    new ListResponse<>(true, "Найдены авторы", authorService.findByName(name, offset, limit).getContent())
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    new ListResponse<>(false, "Авторы не найдены!", null)
            );
        }
    }

    @PostMapping
    public ResponseEntity<DataResponse<Author>> save(@RequestBody AuthorDto author){
        try {
            return ResponseEntity.ok(
                    new DataResponse<>(true, "Автор сохранена!", authorService.save(author))
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    new DataResponse<>(false, "Автор не сохранен!", null)
            );
        }
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestParam Long id, @RequestBody AuthorDto author){
        try {
            authorService.update(authorService.findById(id), author);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Автор сохранен!")
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, "Автор не сохранен!")
            );
        }
    }

    @DeleteMapping
    public ResponseEntity<BaseResponse> delete(@RequestParam Long id){
        try {
            authorService.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Автор удален!")
            );
        } catch (Exception e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, "Автор не удален!")
            );
        }
    }
}
