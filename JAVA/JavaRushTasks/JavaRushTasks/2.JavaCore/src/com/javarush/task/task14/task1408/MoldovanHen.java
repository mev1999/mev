package com.javarush.task.task14.task1408;

 class MoldovanHen extends Hen {
    int getCountOfEggsPerMonth() {return 25;}
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу "
                + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
