package Java_platform.PNUCafeOrderingSystem.pnu.cafe.menu;

import java.awt.*;

public class Coffee extends Beverage {
    public Coffee(String name,Size size) {
        super(name,4500,size);
    }

    @Override
    public int getPrice(){
        switch (size){
            case TALL: return 4500;
            case GRANDE: return 5300;
            default: return basePrice;
        }
    }

    @Override
    protected boolean isSizeValid(Size size){
        return size.equals(Size.GRANDE) || size.equals(Size.TALL);
    }
}
