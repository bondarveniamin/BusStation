import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RouteEnum {
    ROUTE_ONE(1, 1000, 3, "Автобус №1"),
    ROUTE_TWO(2, 2000, 4, "Автобус №2"),
    ROUTE_THREE(3, 3000, 5, "Автобус №3");

    final int number;
    final double cost;
    final int count;
    final String description;
}
