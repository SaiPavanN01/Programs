package io.pavan.interfaces;

public class NiceCar implements Engine{

    private Engine engine;
    private Media player = new CDPlayer();

    public NiceCar() {
        this.engine= new ElectricEngine();
    }

    @Override
    public void start() {
        engine.start();
    }

    @Override
    public void stop() {
        engine.stop();
    }

    @Override
    public void acc() {
        engine.acc();
    }

    public void startMusic() {
        player.start();
    }

    public void stopMusic() {
        player.stop();
    }
    public void upgradeEngine(){
        this.engine=new PowerEngine();
    }
}
