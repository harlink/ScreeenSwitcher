package ctec.screeenswitcher.controller;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import ctec.screeenswitcher.R;
import ctec.screeenswitcher.SecondActivity;

public class MainActivity extends ActionBarActivity
{
	private ArrayList<Integer> colorList;
	private Button firstScreenButton;
	private Button colorSwitchButton;
	private Button buttonColorSwitchButton;
	private RelativeLayout appLayout;

	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		firstScreenButton = (Button) findViewById(R.id.firstScreenButton);
		colorSwitchButton = (Button) findViewById(R.id.colorSwitchButton);
		buttonColorSwitchButton = (Button) findViewById(R.id.buttonColorSwitchButton);
		appLayout = (RelativeLayout) findViewById(R.id.appLayout);
		
		colorList = new ArrayList<Integer>();
		fillTheColorList();
		setupListeners();
	}
	
	private void fillTheColorList()
	{
		colorList.add( R.color.pink);
		colorList.add( R.color.green);
		colorList.add( R.color.cyan);
		colorList.add( R.color.orange);	
		
	}

	private void setupListeners()
	{
		firstScreenButton.setOnClickListener(new View.OnClickListener()
		{
	
			@Override
			public void onClick(View currentView)
			{
				Intent myIntent = new Intent(currentView.getContext(), SecondActivity.class);
				startActivityForResult(myIntent,0);
			
			}
		});
		
		colorSwitchButton.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View currentView)
			{
				int randomPosition = (int) (Math.random() * colorList.size());
				appLayout.setBackgroundResource(colorList.get(randomPosition));
				
			}
			
		});
		
		buttonColorSwitchButton.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View currentView)
			{
				int randomPosition = (int) (Math.random() * colorList.size());
				firstScreenButton.setBackgroundResource(colorList.get(randomPosition));
				buttonColorSwitchButton.setBackgroundResource(colorList.get(randomPosition));
				colorSwitchButton.setBackgroundResource(colorList.get(randomPosition));
				
				firstScreenButton.setTextColor(colorList.get(randomPosition));
				buttonColorSwitchButton.setTextColor(colorList.get(randomPosition));
				colorSwitchButton.setTextColor(colorList.get(randomPosition));
				
			}
			
		});
	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
