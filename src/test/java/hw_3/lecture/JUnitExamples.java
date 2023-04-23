package hw_3.lecture;

import org.junit.jupiter.api.*;

public class JUnitExamples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Это beforeAll()");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    Это beforeEach()");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Это afterAll()");
    }

    @AfterEach
    void afterEach() {
        System.out.println("    Это afterEach()");
    }

    @Test
    void firstTest() {
        System.out.println("        Это 1 firstTest()");
    }

    @Test
    void secondTest() {
        System.out.println("        Это 2 secondTest()");
    }
}