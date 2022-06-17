package edu.My_5520_team25_project.game.collision;


import android.content.Context;

import java.util.ArrayList;

import edu.My_5520_team25_project.game.gravity.GravityThread;
import edu.My_5520_team25_project.game.ladder.Ladder;
import edu.My_5520_team25_project.game.ladder.LadderTempData;

/**
 * 控制小人和梯子的碰撞类,老规矩，单利
 */
public class ControlTheCollision {


    private static ControlTheCollision mControlTheCollision;


    private ArrayList<LadderTempData> arrayList;

    //过滤一下坐标
    private static ArrayList<LadderTempData> garr;


    public static ControlTheCollision getControlTheCollision() {

        if (garr == null) {
            garr = new ArrayList<>();
        }


        if (mControlTheCollision == null) {


            synchronized (ControlTheCollision.class) {


                if (mControlTheCollision == null) {

                    mControlTheCollision = new ControlTheCollision();

                    return mControlTheCollision;

                } else {


                    return mControlTheCollision;
                }

            }


        } else {


            return mControlTheCollision;
        }


    }

    /**
     * 初始化
     */

    public void collision(ArrayList<LadderTempData> arrayList, int mLocationY, int x, GravityThread gravityThread, Context mContext) {

        garr.clear();

        for (int i = 0; i < arrayList.size(); i++) {
            LadderTempData ladderTempData = arrayList.get(i);
            int ladderY = ladderTempData.getLadderY();

            if (ladderY > 0) {
                garr.add(ladderTempData);

            }

            if (arrayList.size() < 5) {

                Ladder.temp.addAll(arrayList);
                arrayList.clear();


                Ladder.getInstance().initData(mContext);
                return;
            }

            if (arrayList.get(i).getLadderY() > mContext.getResources().getDisplayMetrics().heightPixels) {

                LadderTempData remove = arrayList.remove(i);
                i--;

            }

        }


        for (int i = 0; i < garr.size(); i++) {


            LadderTempData ladderTempData = garr.get(i);

            int ladderY = ladderTempData.getLadderY();
            int ladderX = ladderTempData.getLadderX();

            if (mLocationY < (ladderY + 50) && mLocationY > (ladderY - 50) && x > (ladderX - 40) && x < (ladderX + 300)) {

                gravityThread.height = ladderY + 20;

                break;

            } else {

                gravityThread.initX();
            }

        }


    }


}
