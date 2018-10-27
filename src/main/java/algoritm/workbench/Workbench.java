package algoritm.workbench;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Workbench {
    public String createTorch(List<Element> elements) {
        Collections.sort(elements);
        List<Element> fireWoodList = elements.stream()
                .filter(element -> !element.getType().equals(Type.EMPTY)).collect(Collectors.toList());

        if (isTorchRulesAreMet(fireWoodList)) {
            return "Torch!";
        }
        return ":-(";
    }

    private boolean isTorchRulesAreMet(List<Element> fireWoodList) {
        return fireWoodList.size() == 2 && isFirstElementFireSecondWood(fireWoodList) &&
                isElementsOneSameAxisX(fireWoodList) && isElementsOneByOneOnAxisY(fireWoodList);
    }

    private boolean isElementsOneByOneOnAxisY(List<Element> fireWoodList) {
        return fireWoodList.get(0).getY() + 1 == fireWoodList.get(1).getY();
    }

    private boolean isElementsOneSameAxisX(List<Element> fireWoodList) {
        return fireWoodList.get(0).getX() == (fireWoodList.get(1).getX());
    }

    private boolean isFirstElementFireSecondWood(List<Element> fireWoodList) {
        return fireWoodList.get(0).getType().equals(Type.FIRE) && fireWoodList.get(1).getType().equals(Type.WOOD);
    }


}
