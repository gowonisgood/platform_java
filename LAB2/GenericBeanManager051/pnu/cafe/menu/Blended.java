package Java_platform.GenericBeanManager051.pnu.cafe.menu;

public class Blended extends Beverage {
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
