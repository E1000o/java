public class Dozen {
    private int chocolateChip;
    private int peanutButter;
    private int oatmealRaisin;
    
    Dozen() {
        this.setChocolateChip(0);
        this.setPeanutButter(0);
        this.setOatmealRaisin(0);
    }

    public int getChocolateChip() {
        return chocolateChip;
    }
    
    public void setChocolateChip(int chocolateChip) {
        this.chocolateChip = chocolateChip;
    }

    public int getPeanutButter() {
        return peanutButter;
    }

    public void setPeanutButter(int peanutButter) {
        this.peanutButter = peanutButter;
    }

    public int getOatmealRaisin() {
        return oatmealRaisin;
    }

    public void setOatmealRaisin(int oatmealRaisin) {
        this.oatmealRaisin = oatmealRaisin;
    }
}