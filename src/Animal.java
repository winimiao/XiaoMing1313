public class Animal {
    private String species;
    private String sex;
    private int age;

    public Animal(String species, String sex, int age) {
        this.species = species;
        this.sex = sex;
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}
