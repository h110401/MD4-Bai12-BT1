package rikkei.academy.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import rikkei.academy.model.Category;
import rikkei.academy.service.category.ICategoryService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class CategoryFormatter implements Formatter<Category> {

    private final ICategoryService categoryService;

    public CategoryFormatter(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Optional<Category> category = categoryService.findById(Long.valueOf(text));
        return category.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return null;
    }
}
