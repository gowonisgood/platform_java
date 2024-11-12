package Java_platform.PNUCafeOrderingSystem.pnu.cafe.menu;

public class Teavana extends Beverage {
    public Teavana(String name) {
        super(name,4500,Size.TALL);
    }

    @Override
    public int getPrice(){
        return basePrice;
    }

    @Override
    protected boolean isSizeValid(Size size){
        return size.equals(Size.TALL);
    }
}
