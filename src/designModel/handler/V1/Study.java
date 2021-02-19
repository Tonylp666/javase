package designModel.handler.V1;

public class Study {
    private void study(PreparationList preparationList){
        if (preparationList.isHaveBreakfast()){
            System.out.println("吃早餐完成！");
        }

        if (preparationList.isWashFace()){
            System.out.println("洗脸完成！");
        }

        if (preparationList.isWashFair()){
            System.out.println("洗头完成！");
        }

        System.out.println(" 上学！");
    }
}
