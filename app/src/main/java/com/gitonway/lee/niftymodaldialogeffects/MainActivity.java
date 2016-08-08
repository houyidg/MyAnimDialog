package com.gitonway.lee.niftymodaldialogeffects;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;


public class MainActivity extends Activity {
    private Effectstype effect;
    private NiftyDialogBuilder niftyDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void dialogShow(View v) {
        niftyDialogBuilder = NiftyDialogBuilder.getInstance(this);
        switch (v.getId()) {
            case R.id.fadein:
                effect = Effectstype.Fadein;
                break;
            case R.id.slideleft:
                effect = Effectstype.Slideleft;
                break;
            case R.id.slidetop:
                effect = Effectstype.Slidetop;
                break;
            case R.id.fall:
                effect = Effectstype.Fall;
                break;
        }
        niftyDialogBuilder
                .withTitle("Modal Dialog")                                  //.withTitle(null)  no title
                .withTitleColor("#FFFFFF")                                  //def
                .withDividerColor("#11000000")                              //def
                .withMessage("This is a modal Dialog.")                     //.withMessage(null)  no Msg
                .withMessageColor("#FFFFFFFF")                              //def  | withMessageColor(int resid)
                .withDialogColor("#FFE74C3C")                               //def  | withDialogColor(int resid)                               //def
                .withIcon(getResources().getDrawable(R.drawable.icon))
                .isCancelable(false)                       //def    | isCancelable(true)
                .withDuration(300)                                          //def
                .withEffect(effect)                                         //def Effectstype.Slidetop
                .withButton1Text("OK")                                      //def gone
                .withButton2Text("Cancel")                                  //def gone
                .setCustomView(R.layout.custom_view, v.getContext())
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "i'm btn1", Toast.LENGTH_SHORT).show();
                        niftyDialogBuilder.dismissAnim();
                    }
                })
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "i'm btn2", Toast.LENGTH_SHORT).show();
                        niftyDialogBuilder.dismissAnim();
                    }
                });
        niftyDialogBuilder.show();
    }
}
