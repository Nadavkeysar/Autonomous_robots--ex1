import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SimulationWindow {

	public static long start_time;
	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulationWindow window = new SimulationWindow();
					window.frame.setVisible(true);
					window.frame.setResizable(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SimulationWindow() { initialize(); }

	public static JLabel info_label;
	public static boolean return_home = false;
	boolean toogleStop = true;
	private void initialize() {
		frame = new JFrame();
		frame.setSize(3000,700);
		frame.setTitle("Drone Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);


		JButton stopBtn = new JButton("Start/Pause");
		stopBtn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  if(toogleStop) {
					  CPU.stopAllCPUS();
				  } else {
					  CPU.resumeAllCPUS();
				  }
				  toogleStop = !toogleStop;
			  }
		});
		stopBtn.setBounds(950, 0, 170, 50);
		frame.getContentPane().add(stopBtn);
		
		JButton speedBtn1 = new JButton("speedUp");
		speedBtn1.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.speedUp();
			  }
		});
		speedBtn1.setBounds(950, 100, 100, 50);
		frame.getContentPane().add(speedBtn1);
		
		JButton speedBtn2 = new JButton("speedDown");
		speedBtn2.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.speedDown();
			  }
		});
		speedBtn2.setBounds(1050, 100, 150, 50);
		frame.getContentPane().add(speedBtn2);
		
		JButton spinBtn1 = new JButton("spin180");
		spinBtn1.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(180);
			  }
		});
		spinBtn1.setBounds(950, 200, 100, 50);
		frame.getContentPane().add(spinBtn1);
		
		JButton spinBtn2 = new JButton("spin90");
		spinBtn2.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(90);
			  }
		});
		spinBtn2.setBounds(1050, 200, 100, 50);
		frame.getContentPane().add(spinBtn2);
		
		JButton spinBtn3 = new JButton("spin60");
		spinBtn3.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(60);
			  }
		});
		spinBtn3.setBounds(1150, 200, 100, 50);
		frame.getContentPane().add(spinBtn3);
		
		JButton spinBtn4 = new JButton("spin45");
		spinBtn4.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(60);
			  }
		});
		spinBtn4.setBounds(950, 300, 100, 50);
		frame.getContentPane().add(spinBtn4);
		
		JButton spinBtn5 = new JButton("spin30");
		spinBtn5.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(30);
			  }
		});
		spinBtn5.setBounds(1150, 300, 100, 50);
		frame.getContentPane().add(spinBtn5);
		
		JButton spinBtn6 = new JButton("spin-30");
		spinBtn6.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(-30);
			  }
		});
		spinBtn6.setBounds(1250, 300, 100, 50);
		frame.getContentPane().add(spinBtn6);
		
		JButton spinBtn7 = new JButton("spin-45");
		spinBtn7.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(-45);
			  }
		});
		spinBtn7.setBounds(1050, 300, 100, 50);
		frame.getContentPane().add(spinBtn7);
		
		JButton spinBtn8 = new JButton("spin-60");
		spinBtn8.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(-60);
			  }
		});
		spinBtn8.setBounds(1250, 200, 100, 50);
		frame.getContentPane().add(spinBtn8);
		
		JButton toogleMapBtn = new JButton("toogle Map");
		toogleMapBtn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  toogleRealMap = !toogleRealMap;
			  }
		});
		toogleMapBtn.setBounds(950, 400, 120, 50);
		frame.getContentPane().add(toogleMapBtn);

		JButton toogleAIBtn = new JButton("toogle AI");
		toogleAIBtn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  long start_time = System.currentTimeMillis();
				  toogleAI = !toogleAI;
			  }
		});
		toogleAIBtn.setBounds(1050, 400, 120, 50);
		frame.getContentPane().add(toogleAIBtn);

		JButton returnBtn = new JButton("Return Home");
		returnBtn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  return_home = !return_home;
				  algo1.speedDown();
				  algo1.spinBy(180, true, new Func() {
						@Override
						public void method() {
							algo1.speedUp();
						}
					});
			  }
		});
		returnBtn.setBounds(1150, 400, 120, 50);
		frame.getContentPane().add(returnBtn);
		
		JButton Graph = new JButton("Open Graph");
		Graph.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.mGraph.drawGraph();
			  }
		});
		Graph.setBounds(1250, 400, 120, 50);
		frame.getContentPane().add(Graph);
		
		/*
		 * Info label 
		 */
		
		
		info_label = new JLabel();
		info_label.setBounds(950, 500, 300, 200);
		frame.getContentPane().add(info_label);
		
		/*
		 * Info label 
		 */
		
		
		info_label2 = new JLabel();
		info_label2.setBounds(850, 450, 300, 200);
		frame.getContentPane().add(info_label2);
		
		main();
	}
	public JLabel info_label2;
	public static boolean toogleRealMap = true;
	public static boolean toogleAI = false;
	
	public static AutoAlgo1 algo1;
	
	
	public void main() {
		int map_num = 1;
		Point[] startPoints = {
				new Point(100,50),
				new Point(50,60),
				new Point(73,68),
				new Point(84,73),
				new Point(92,100)};
		
		Map map = new Map("C:\\Users\\BASE\\Desktop\\אוניברסיטה\\שנה ג\\סמסטר ב\\רובוטים אוטונומיים\\DroneSimulator-master (2)\\DroneSimulator-master\\Maps\\p1" + map_num + ".png",startPoints[map_num-1]);
		
		algo1 = new AutoAlgo1(map);
		
		Painter painter = new Painter(algo1);
		painter.setBounds(0, 0, 2500, 2500);
		frame.getContentPane().add(painter);
		
		CPU painterCPU = new CPU(200,"painter"); // 60 FPS painter
		painterCPU.addFunction(frame::repaint);
		painterCPU.play();
		
		algo1.play();
		
		CPU updatesCPU = new CPU(60,"updates");
		updatesCPU.addFunction(algo1.drone::update);
		updatesCPU.play();
		
		CPU infoCPU = new CPU(6,"update_info");
		infoCPU.addFunction(this::updateInfo);
		infoCPU.play();
	}
	
	public void updateInfo(int deltaTime) {
		info_label.setText(algo1.drone.getInfoHTML());
		info_label2.setText("<html>" + String.valueOf(algo1.counter) + " <BR>isRisky:" + String.valueOf(algo1.is_risky) + 
				"<BR>" + String.valueOf(algo1.risky_dis) + "</html>");
		
	}
	
	public void stopCPUS() {
		CPU.stopAllCPUS();
	}
	
	public void resumseCPUS() {
		CPU.stopAllCPUS();
	}
}
