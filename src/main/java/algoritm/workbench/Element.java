package algoritm.workbench;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Element implements Comparable<Element> {
    Type type;
    int x, y;

    @Override
    public int compareTo(Element element) {
        Integer result = Integer.compare(this.x, element.x);
        if (result == 0) {
            result = Integer.compare(this.y, element.y);
        }
        return result;

    }
}
