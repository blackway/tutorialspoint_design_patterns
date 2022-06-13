package behavioral.template;


public class TemplatePatternMain {


    //template method, final so subclasses can't override
    public static void main(String...args) {
        TemplatePatternMain mainCls  = new TemplatePatternMain();
        System.out.println("hello world! design patterns : "+mainCls.getClass().getName());
        
        HouseTemplate houseType = new WoodenHouse();
        //using template method
        
        houseType.buildHouse();
        System.out.println("**********");

        houseType = new GlassHouse();
        //using template method
        houseType.buildHouse();
 
    }
}

abstract class HouseTemplate {

    //template method, final so subclasses can't override
    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        BuildWindows();
        System.out.println("House is built.");
    }

    //default implementation
    private void buildFoundation() {
        System.out.println("Building class Windows");
    }

    //methods to be implemented by subclasses
    public abstract void buildPillars();
    public abstract void buildWalls();

    
    private void BuildWindows() {
        System.out.println("Building foundation with cement, iron rods and sand");
    }
}

class WoodenHouse extends HouseTemplate {

    @Override
    public void buildPillars() {
       System.out.println("Building Wooden Walls"); 
    }

    @Override
    public void buildWalls() {
       System.out.println("Building Pillars with Wood coating"); 
    }

}

class GlassHouse extends HouseTemplate {

    @Override
    public void buildPillars() {
       System.out.println("Building Glass Walls"); 
    }

    @Override
    public void buildWalls() {
       System.out.println("Building Pillars with Glass coating"); 
    }

}












