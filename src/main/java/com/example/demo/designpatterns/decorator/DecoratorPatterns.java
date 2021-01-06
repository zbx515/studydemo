package com.example.demo.designpatterns.decorator;

/**
 * 装饰器模式
 */
public class DecoratorPatterns {
    public static void main(String[] args) {
        //new一个唐门
        //Role role = new TangM();
        Role role = new Yhua();
        System.out.println("-----------");
        FusuDecorator fusuDecorator = new FusuDecorator(role);
        fusuDecorator.dress();
        System.out.println("-----------");
        SxiuDecorator sxiuDecorator = new SxiuDecorator(role);
        sxiuDecorator.dress();

    }
}

/**
 * 以天刀手游理解装饰器模式
 * 每个门派，或者每个游戏人物为具体物件，而装扮则为不同的装饰
 * 每个角色都有其外观属性
 */
interface Role{
    //外观
    void appearance();
}

/**
 * 唐门角色
 */
class TangM implements Role{
    @Override
    public void appearance() {
        System.out.println("唐门角色初始化");
    }
}

/**
 * 移花角色
 */
class Yhua implements Role{
    @Override
    public void appearance() {
        System.out.println("移花角色初始化");
    }
}

/**
 * 装扮的抽象
 */
abstract class Decorator implements Role{
    private Role role;
    public Decorator(Role role){
        this.role = role;
    }
    @Override
    public void  appearance(){
        role.appearance();
    }
}

/**
 * 心王扶苏 装扮
 */
class FusuDecorator extends Decorator{

    public FusuDecorator(Role role) {
        super(role);
    }

    public void dress(){
        super.appearance();
        System.out.println("心王-扶苏装扮已穿戴");
    }
}

/**
 * 圣秀装扮
 */
class SxiuDecorator extends Decorator{

    public SxiuDecorator(Role role) {
        super(role);
    }

    public void dress(){
        super.appearance();
        System.out.println("圣秀-装扮已穿戴");
    }
}