package Java_platform.PNUCafeOrderingSystem.pnu.cafe.menu;

import java.awt.*;

public class Blended extends Beverage{
    public Blended(String name) {
        super(name,6600, Size.GRANDE);
    }

    @Override
    public int getPrice(){
        return basePrice;
    }

    @Override
    protected boolean isSizeValid(Size size){
        //System.out.println("blended: "+size);
        return size.equals(Size.GRANDE);
    }
}
