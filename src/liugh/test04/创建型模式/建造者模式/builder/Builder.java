package liugh.test04.创建型模式.建造者模式.builder;

public abstract class Builder {
    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract Product getBuildResult();
}
