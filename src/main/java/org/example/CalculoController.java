package org.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@WebServlet("/Calculo")
public class CalculoController extends HttpServlet {

    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    private final TriFunction <Double, Double, String, String> calculate = (a, b, op) -> {
        if (a == null || b == null || op == null) {
            throw new IllegalArgumentException("Null value is not allowed");
        } else {
            return switch (op) {
                case "+" -> String.valueOf(a + b);
                case "-" -> String.valueOf(a - b);
                case "*" -> String.valueOf(a * b);
                case "/" -> {
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero is not allowed");
                    }
                    yield String.valueOf(a / b);
                }
                default -> throw new IllegalArgumentException("Invalid operation");
            };
        }
    };

    @GetMapping("/")
    public String local() {
        return "calcula";
    }

    @PostMapping("/Calcule")
    public String calcule(Model model, Calculo calculo) {
        model.addAttribute("resultado", calculate.apply(Double.valueOf(calculo.getValor1()), Double.valueOf(calculo.getValor2()), calculo.getOperacao()));
        return "calcula";
    }
}
