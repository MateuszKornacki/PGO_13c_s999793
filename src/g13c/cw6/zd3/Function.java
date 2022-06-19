package g13c.cw6.zd3;

abstract class Function implements Fun{

    /**
     * zwiększanie wszystkich
     * współczynników klasy funkcji o delta
     * @param delta
     */
    abstract void increaseCoefficientsBy(double delta);

    /**
     * zmniejszanie wszystkich
     * współczynników klasy funkcji o delta
     * @param delta
     */
    abstract void decreaseCoefficientsBy(double delta);

}
