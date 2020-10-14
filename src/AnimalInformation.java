import java.sql.SQLOutput;
import java.util.*;


public class AnimalInformation {
    public static void main(String[] args) {
        ArrayList<Animal> AnimalInformation = new ArrayList<>();


        String menu = "1:add\n2:delete\n3:list\n";
        while (true) {
            System.out.println(menu);
            Scanner input = new Scanner(System.in);//输入的赋值给INPUT
            String choose = input.next();
            switch (choose) {
                case "1":
                    System.out.println("执行添加。。。");
                    add(AnimalInformation);
                    break;
                case "2":
                    System.out.println("执行删除。。。");
                    delete(AnimalInformation);
                    break;
                case "3":
                    System.out.println("执行输出。。。");
                    print(AnimalInformation);
                    break;
            }
        }





    }

    public static void add(List<Animal> list) {
        Scanner input = new Scanner(System.in);

        System.out.println("给我 名字");
        String name = input.next();
        System.out.println("给我 性别");
        String sex = input.next();
        System.out.println("给我  年龄");
        int age = input.nextInt();

        Animal animal = new Animal(name, sex, age);
        list.add(animal);

    }

    public static void delete(List<Animal> list){
        Scanner input=new Scanner(System.in);

        System.out.println("想删除第几条");
        int index=input.nextInt();

        list.remove(index-1);
    }


    public static void print(List<Animal> list) {
        List<Animal> sortList = new ArrayList<>();
        //每次找出剩余数据中最小的那个数然后添加进sortList当中
        //因为在找到一个最小数加到sortList中后遍历原列表进行查找最小值时会产生影响所以使用contains
        //判断是否是已经排过序的元素如果是的话就直接跳过
        //这里三层循环 k表示需要查找的次数    6个数据需要查找6次
        //j表示 待排序的元素  两层循环即是正常的冒泡排序  一次冒泡可以找到最小的那个值
        //但是由于我们不允许改变原数据列的顺序  所以在比较完了之后并没有执行交换位置的操作
        //就会出现这种情况：
        /*
         * 第一个数比第二个数大且第二个数是最小的那个，那么经过一次冒泡第二个数已经找出来了
         * 但是他在原数据列中的位置没有改变，如果进行第二次冒泡，外层循环索引从第二个数开始（最小的那个）
         * 最后找到的仍然是最小的那个数，这样下来第一个位置的数就被忽略了，永远不会把它排序加入到排序后的队列
         *
         */
        for (int k = 0; k < list.size(); k++) {
            for (int j = 0; j < list.size(); j++) {
                Animal a = list.get(j);
                if (!sortList.contains(a)) {
                    for (int i = 0; i < list.size(); i++) {
                        Animal b = list.get(i);
                        if (!sortList.contains(b)) {
                            if (a.getAge() > b.getAge()) {
                                a = b;
                            }
                        }
                    }
                    sortList.add(a);
                }
            }
        }

        for (Animal tmp : sortList) {
            System.out.println("Age:" + tmp.getAge() + " Sex:" + tmp.getSex() + " Like:" + tmp.getSpecies());
        }

    }
}
