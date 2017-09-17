package com.anisdroid.Object_Animator_AnimatorSet;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.animation.*;

public class MainActivity extends Activity 
{
	
	ImageView iii;
	Button st_bt;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		iii = (ImageView) findViewById(R.id.img);
		st_bt = (Button) findViewById(R.id.start_button);
		
		st_bt.setOnClickListener(
			new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					
					ObjectAnimator alphaA = ObjectAnimator.ofFloat(iii,View.ALPHA,0,1);
					alphaA.setDuration(4000);
					
					ObjectAnimator transA = ObjectAnimator.ofFloat(iii,View.TRANSLATION_X,-500,0);
					transA.setDuration(4000);
					
					ObjectAnimator rotateA = ObjectAnimator.ofFloat(iii,View.ROTATION,0,360);
					rotateA.setDuration(4000);
					
					PropertyValuesHolder pvhx = PropertyValuesHolder.ofFloat(View.SCALE_X,0,1);
					PropertyValuesHolder pvhy = PropertyValuesHolder.ofFloat(View.SCALE_Y,0,1);
					
					ObjectAnimator scaleA = ObjectAnimator.ofPropertyValuesHolder(iii,pvhx,pvhy);
					scaleA.setDuration(4000);
					
					AnimatorSet anim = new AnimatorSet();
					//anim.play(alphaA).before(transA).after(rotateA).with(scaleA);
					//anim.playSequentially(alphaA,transA,rotateA,scaleA);
					anim.playTogether(alphaA,transA,rotateA,scaleA);
					anim.start();
					
				}
				
				
			}
		);
		
    }
}
