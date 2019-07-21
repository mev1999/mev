package com.javarush.task.task14.task1408;

 class RussianHen extends Hen {
    int getCountOfEggsPerMonth() {return 30;}
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу "
                + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
