package com.renvictus.salarycalculator.calculations;

public class SalaryConverter {

    public static Double grossIncomeToNet(Double salaryGross) {

        //Darbuotojo sumokami mokesciai
        //double employeeTaxes = (salaryGross - CalculateNPD.grossNPD(salaryGross))
        double employeeTaxes = salaryGross * Const.INCOME_TAX
                + salaryGross * (
                Const.PENSION_INSURANCE
                        + Const.MANDATORY_HEALTH_INSURANCE
                        + Const.ILLNESS_SOCIAL_INSURANCE
                        + Const.MOTHERHOOD_SOCIAL_INSURANCE);

        return (double) (Math.round((salaryGross - employeeTaxes) * 100) / 100);
    }

    public static Double netIncomeToGross(Double salaryNet) {

        //Darbuotojo sumokami mokesciai
        //double employeeTaxes = (salaryNet - CalculateNPD.netNPD(salaryNet))
//        double employeeTaxes = salaryNet * Const.INCOME_TAX
//                + salaryNet * (
//                Const.PENSION_INSURANCE
//                        + Const.MANDATORY_HEALTH_INSURANCE
//                        + Const.ILLNESS_SOCIAL_INSURANCE
//                        + Const.MOTHERHOOD_SOCIAL_INSURANCE);

        //Darbuotojo sumokami mokesciai
        return (double) Math.round((salaryNet * salaryNet / grossIncomeToNet(salaryNet)) * 100) / 100;
    }
}
