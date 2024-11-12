package Java_platform.GenericBeanManager051.pnu.cafe.menu;

public abstract class Beverage {

    public enum Size{
        TALL, GRANDE, VENTI;
    }

    public static class Factory{
        public static Beverage createBeverage(String type, String name){
            //System.out.println("Creating beverage of type: "+ type+", name: "+name);//debug
            switch (type.toLowerCase()){

                case "coffee":
                    return new Coffee(name, Size.TALL);
                case "blended":
                    return new Blended(name);
                case "teavana":
                    return new Teavana(name);
                default:
                    throw new IllegalArgumentException("Invalid beverage type: " + type);
            }

        }

    }


    String name;
    int basePrice;
    Size size;
    Beverage(String name, int basePrice, Size size) {
        this.name = name;
        this.basePrice = basePrice;
        this.size = size;
    }

    public String getName(){
        return name;
    }

    public Size getSize(){
        return size;
    }

    public boolean setSize(Size size){
        //System.out.println("Attempting to set size to " + size + " for " + name); //debug

        if(isSizeValid(size)){
            this.size = size;
            //System.out.println("Successfully set size to " + size + " for " + name); //debug
            return true;
        }
        //System.out.println("Fail to set size to " + size + " for " + name);
        return false;
    }

    public abstract int getPrice();
    protected abstract boolean isSizeValid(Size size);
    @Override
    public String toString(){
        return name+" ("+size+")";
    }


}
