package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**К каждой функции прикреплена документация. Данные сценарии выбраны так как в них наиболее вероятна ошибка.
*/

class ListsOfNumbersTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private List<Double> list1;
    private List<Double> list2;


    @BeforeEach
    void setUp() {
        list1 = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0 ,7.0));
        list2 = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.1, 4.0, 5.0, 6.0 ,7.0));
        System.setOut(new PrintStream(outputStreamCaptor));
    }

        /**
         * Проверка корректной инициализации класса
         *
         */

    @Test
    void testInitilizeObject(){
        ListsOfNumbers listsOfNumbers = new ListsOfNumbers();
        assertNotNull(listsOfNumbers, "Объект не инициализирован");
    }

    @Test
    void testNotInitilizeObject(){
        ListsOfNumbers listsOfNumbers = null;
        assertNull( listsOfNumbers, "Объект не NULL");
    }

    @Test
    void testSetList1() {
        ListsOfNumbers listsOfNumbers = new ListsOfNumbers();
        listsOfNumbers.setList1(list1);
        assertSame(listsOfNumbers.getList1(), list1);
    }

    @Test
    void testSetList2() {
        ListsOfNumbers listsOfNumbers = new ListsOfNumbers();
        listsOfNumbers.setList2(list2);
        assertSame(listsOfNumbers.getList2(), list2);
    }

    @Test
    void testGetList1() {
        ListsOfNumbers listsOfNumbers = new ListsOfNumbers();
        listsOfNumbers.setList1(list1);
        assertNotNull(listsOfNumbers.getList1(), "Списка1 не существует");

    }

    @Test
    void testGetList2() {
        ListsOfNumbers listsOfNumbers = new ListsOfNumbers();
        listsOfNumbers.setList2(list2);
        assertNotNull(listsOfNumbers.getList2(), "Списка2 не существует");
    }

    /**
     * Проверка средних значений списков
     */
    @Test
    void testGetAverage() {
        ListsOfNumbers listsOfNumbers = new ListsOfNumbers();
        listsOfNumbers.setList1(list1);
        listsOfNumbers.setList2(list2);
        assertEquals(listsOfNumbers.getAverage(listsOfNumbers.getList1()), 4.0);
        assertEquals(listsOfNumbers.getAverage(listsOfNumbers.getList2()), 4.014285714285714);

    }

    /**
     * Проверка сравнения средних значений списков
     */
    @Test
    void testMessageCompareAverages1() {
        ListsOfNumbers listsOfNumbers = new ListsOfNumbers();
        listsOfNumbers.setList1(Arrays.asList(1.0, 1.0, 1.0));
        listsOfNumbers.setList2(Arrays.asList(1.0, 3.0, 1.0));
        listsOfNumbers.compareAverages();
        assertEquals("Список1 имеет меньшее среднее значение", outputStreamCaptor.toString().trim());
        }

    @Test
    void testMessageCompareAverages2() {
        ListsOfNumbers listsOfNumbers = new ListsOfNumbers();
        listsOfNumbers.setList1(Arrays.asList(1.0, 2.0, 1.0));
        listsOfNumbers.setList2(Arrays.asList(1.0, 1.0, 1.0));
        listsOfNumbers.compareAverages();
        assertEquals("Список1 имеет большее среднее значение", outputStreamCaptor.toString().trim());
    }

    @Test
    void testMessageCompareAverages3() {
        ListsOfNumbers listsOfNumbers = new ListsOfNumbers();
        listsOfNumbers.setList1(Arrays.asList(1.0, 2.0, 1.0));
        listsOfNumbers.setList2(Arrays.asList(1.0, 2.0, 1.0));
        listsOfNumbers.compareAverages();
        assertEquals("Средние значения Списка1 и Списка2 равны", outputStreamCaptor.toString().trim());
    }

    /**
     * Пpоверка на NullPointerException
     */

    @Test
    void testOneListNull() {
        ListsOfNumbers listsOfNumbers = new ListsOfNumbers();
        listsOfNumbers.setList1(Arrays.asList(1.0, 2.0, 1.0));
        assertThrows(NullPointerException.class, () -> listsOfNumbers.compareAverages());
    }

    @Test
    void testSecondListNull() {
        ListsOfNumbers listsOfNumbers = new ListsOfNumbers();
        listsOfNumbers.setList2(Arrays.asList(1.0, 2.0, 1.0));
        assertThrows(NullPointerException.class, () -> listsOfNumbers.compareAverages());
    }

    @Test
    void testOneListIsEmpty() {
        ListsOfNumbers listsOfNumbers = new ListsOfNumbers();
        listsOfNumbers.setList1(new ArrayList<>());
        listsOfNumbers.setList2(Arrays.asList(1.0, 2.0, 1.0));
        assertThrows(NullPointerException.class, () -> listsOfNumbers.compareAverages());
    }

    @Test
    void testSecondListIsEmpty() {
        ListsOfNumbers listsOfNumbers = new ListsOfNumbers();
        listsOfNumbers.setList1(Arrays.asList(1.0, 2.0, 1.0));
        listsOfNumbers.setList2(new ArrayList<>());
        assertThrows(NullPointerException.class, () -> listsOfNumbers.compareAverages());
    }

}