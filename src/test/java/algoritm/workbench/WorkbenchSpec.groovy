package algoritm.workbench

import spock.lang.Specification

class WorkbenchSpec extends Specification {

    def "should create torch or return sad icon"() {
        given:
        Workbench workbench = new Workbench()
        when:
        String result = workbench.createTorch(elementsList)
        then:
        expected == result

        where:
        elementsList            | expected
        elementsFormingTorch()  | "Torch!"
        elementsFormingTorch2() | "Torch!"
        emptyElements()         | ":-("
        tooManyElements()       | ":-("
        badCombination()        | ":-("
        duplicated()            | ":-("
        tooLongDistance()       | ":-("
        outsideTheOneXaxis()    | ":-("
    }

    private static List<Element> elementsFormingTorch() {
        return Arrays.asList(new Element(Type.EMPTY, 0, 0), new Element(Type.EMPTY, 0, 1), new Element(Type.EMPTY, 0, 2),
                new Element(Type.EMPTY, 1, 0), new Element(Type.EMPTY, 1, 1), new Element(Type.EMPTY, 1, 2),
                new Element(Type.EMPTY, 2, 0), new Element(Type.FIRE, 2, 1), new Element(Type.WOOD, 2, 2))
    }

    private static List<Element> elementsFormingTorch2() {
        return Arrays.asList(new Element(Type.EMPTY, 0, 0), new Element(Type.EMPTY, 0, 1), new Element(Type.EMPTY, 0, 2),
                new Element(Type.EMPTY, 1, 0), new Element(Type.FIRE, 1, 1), new Element(Type.WOOD, 1, 2),
                new Element(Type.EMPTY, 2, 0), new Element(Type.EMPTY, 2, 1), new Element(Type.EMPTY, 2, 2))
    }

    private static List<Element> tooManyElements() {
        return Arrays.asList(new Element(Type.WOOD, 0, 0), new Element(Type.WOOD, 0, 1), new Element(Type.EMPTY, 0, 2),
                new Element(Type.EMPTY, 1, 0), new Element(Type.EMPTY, 1, 1), new Element(Type.EMPTY, 1, 2),
                new Element(Type.EMPTY, 2, 0), new Element(Type.FIRE, 2, 1), new Element(Type.WOOD, 2, 2))
    }

    private static List<Element> duplicated() {
        return Arrays.asList(new Element(Type.EMPTY, 0, 0), new Element(Type.EMPTY, 0, 1), new Element(Type.EMPTY, 0, 2),
                new Element(Type.EMPTY, 1, 0), new Element(Type.FIRE, 1, 1), new Element(Type.WOOD, 1, 2),
                new Element(Type.EMPTY, 2, 0), new Element(Type.FIRE, 2, 1), new Element(Type.WOOD, 2, 2))
    }

    private static List<Element> emptyElements() {
        return Arrays.asList(new Element(Type.EMPTY, 1, 1), new Element(Type.EMPTY, 0, 1), new Element(Type.EMPTY, 0, 0),
                new Element(Type.EMPTY, 1, 0))
    }

    private static List<Element> badCombination() {
        return Arrays.asList(new Element(Type.EMPTY, 0, 0), new Element(Type.EMPTY, 0, 1), new Element(Type.EMPTY, 0, 2),
                new Element(Type.EMPTY, 1, 0), new Element(Type.EMPTY, 1, 1), new Element(Type.EMPTY, 1, 2),
                new Element(Type.EMPTY, 2, 0), new Element(Type.WOOD, 2, 1), new Element(Type.FIRE, 2, 2))
    }

    private static List<Element> tooLongDistance() {
        return Arrays.asList(new Element(Type.EMPTY, 0, 0), new Element(Type.EMPTY, 0, 1), new Element(Type.EMPTY, 0, 2),
                new Element(Type.EMPTY, 1, 0), new Element(Type.EMPTY, 1, 1), new Element(Type.EMPTY, 1, 2),
                new Element(Type.FIRE, 2, 0), new Element(Type.EMPTY, 2, 1), new Element(Type.WOOD, 2, 2))
    }

    private static List<Element> outsideTheOneXaxis() {
        return Arrays.asList(new Element(Type.EMPTY, 0, 0), new Element(Type.EMPTY, 0, 1), new Element(Type.EMPTY, 0, 2),
                new Element(Type.EMPTY, 1, 0), new Element(Type.FIRE, 1, 1), new Element(Type.EMPTY, 1, 2),
                new Element(Type.EMPTY, 2, 0), new Element(Type.EMPTY, 2, 1), new Element(Type.WOOD, 2, 2))
    }
}
