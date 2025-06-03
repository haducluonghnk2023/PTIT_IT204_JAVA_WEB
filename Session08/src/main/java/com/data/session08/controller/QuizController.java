package com.data.session08.controller;

import com.data.session08.model.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class QuizController {

    private List<Question> questions = new ArrayList<>();

    // Cấu hình danh sách câu hỏi
    public QuizController() {
        questions.add(new Question(1, "https://upload.wikimedia.org/wikipedia/commons/f/fa/Apple_logo_black.svg", "apple"));
            questions.add(new Question(2, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwgRGQLyFS6A-kuPchOlJjI1pee_XCh3OL5w&s", "android"));
        questions.add(new Question(3, "https://s3-sgn09.fptcloud.com/codelearnstorage/Upload/Blog/react-js-co-ban-phan-1-63738082145.3856.jpg", "react"));
        // Thêm các câu hỏi khác nếu cần
    }

    // Phương thức để hiển thị câu hỏi ngẫu nhiên
    @GetMapping("/quiz")
    public String showQuiz(Model model) {
        Random random = new Random();
        Question randomQuestion = questions.get(random.nextInt(questions.size()));
        model.addAttribute("question", randomQuestion);
        model.addAttribute("guessCount", 0); // Đếm số lần đoán
        return "quiz";
    }

    // Phương thức để xử lý câu trả lời của người dùng
    @PostMapping("/guess")
    public String checkAnswer(@ModelAttribute("userAnswer") String userAnswer,
                              @ModelAttribute("question") Question question,
                              @ModelAttribute("guessCount") int guessCount,
                              Model model) {

        // Kiểm tra nếu người dùng đoán đúng
        if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
            model.addAttribute("message", "Đã đoán đúng!");
            return "quiz";
        }

        // Nếu sai, tăng số lần đoán và kiểm tra nếu hết lượt
        guessCount++;
        if (guessCount >= 3) {
            model.addAttribute("message", "Bạn hết lượt đoán");
            return "quiz";
        }

        model.addAttribute("message", "Đoán sai. Còn " + (3 - guessCount) + " lượt.");
        model.addAttribute("guessCount", guessCount); // Cập nhật số lần đoán
        return "quiz";
    }
}
