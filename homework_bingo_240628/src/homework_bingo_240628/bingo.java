package homework_bingo_240628;

import java.util.Scanner;

public class bingo {

	static Scanner input=new Scanner(System.in);
	
	public static void main(String[] args) {

		int randomNum=50;
		int [] randomNumUser = new int[25];
		int [] randomNumCom = new int[25];
		int userNum=0;
		int comNum=0;
		int count=0;
		int bingoCountUser=0;
		int bingoCountCom=0;
		
		int rowCount=0;		// 陛煎 綵堅 
		int verCount=0;		// 撮煎 綵堅
		int diagonal1=0;	// 渠陝摹 綵堅
		int diagonal2=0;	// 渠陝摹 綵堅
		
		int [] rowBingo = new int[randomNumUser.length/5];	// 陛煎 綵堅 蘋遴お		
		int [] verBingo = new int[randomNumUser.length/5];	// 撮煎 綵堅 蘋遴お
		int [] diaBingo = new int[2];	// 渠陝摹 綵堅 蘋遴お
		
		int nextBingoNum=0; 
			
		/*  get user bingo number		*/
		for(int i=0; i<randomNumUser.length; i++)
		{
			randomNumUser[i] = (int)(Math.random()*randomNum)+1;
			while(count<i)
			{
				if(randomNumUser[count]==randomNumUser[i] )
				{
					randomNumUser[i] = (int)(Math.random()*randomNum)+1;
					count=-1;
				}			
				count++;
			}
			count=0;
		}	
		
		/*  get computer bingo number		*/
		for(int i=0; i<randomNumCom.length; i++)
		{
			randomNumCom[i] = (int)(Math.random()*randomNum)+1;
			while(count<i)
			{
				if(randomNumCom[count]==randomNumCom[i] )
				{
					randomNumCom[i] = (int)(Math.random()*randomNum)+1;
					count=-1;
				}			
				count++;
			}
			count=0;
		}	

		while(true) 
		{
			System.out.println(" >> user                                          computer <<");
			System.out.print("忙式式式式成式式式式成式式式式成式式式式成式式式式忖          忙式式式式成式式式式成式式式式成式式式式成式式式式忖\n");
			for(int i=0; i<randomNumUser.length/5; i++)
			{
				
				for(int j=0; j<randomNumUser.length/5; j++)		// print user biongo number
				{
					if(randomNumUser[j+(i*5)]==0)
						 System.out.printf("弛 %2c ",'﹥');
					else
						System.out.printf("弛 %2d ",randomNumUser[j+(i*5)]);
				}
				System.out.print("弛          ");

				for(int j=0; j<randomNumCom.length/5; j++)		// print computer biongo number
				{
					if(randomNumCom[j+(i*5)]==0)
						System.out.printf("弛 %2c ",'﹥');
					else 
						System.out.printf("弛 %2d ",randomNumCom[j+(i*5)]);
				}
				System.out.print("弛");
				System.out.print("\n");
				if(i<randomNumUser.length/5-1)
				{
					System.out.print("戍式式式式托式式式式托式式式式托式式式式托式式式式扣          戍式式式式托式式式式托式式式式托式式式式托式式式式扣");
					System.out.print("\n");
				}
				else if(i==randomNumUser.length/5-1)
					System.out.print("戌式式式式扛式式式式扛式式式式扛式式式式扛式式式式戎          戌式式式式扛式式式式扛式式式式扛式式式式扛式式式式戎\n");
				
			}			
			
			if(bingoCountUser>=5 || bingoCountCom>=5)
			{
				if(bingoCountUser==5)
					System.out.println(" ***  user 蝓 ***");
	
				else if(bingoCountUser>5)
					System.out.println(" -- user bingo over --");
				
				else if(bingoCountCom==5)
					System.out.println(" *** com 蝓 ***");
	
				else if(bingoCountCom>5)
					System.out.println(" -- com bingo over --");
				
				break;
			}			
			/* select user bingo number */
			System.out.print("user 璋濠 殮溘 : ");
			userNum=input.nextInt();
			
			for(int i=0; i<randomNumUser.length; i++)
			{
				if(randomNumUser[i]==userNum)
					randomNumUser[i]=0;

				if(randomNumCom[i]==userNum)
					randomNumCom[i]=0;
			}
			
			int [] rowTemp_1=new int[5];
			int [] rowTemp_2=new int[5];
				
			for(int i=0; i<randomNumCom.length/5; i++)
			{ 
				for(int j=0; j<randomNumCom.length/5-1; j++)
				{
					if(rowBingo[j]>=rowBingo[j+1])
					{
						rowTemp_1[j]=rowBingo[j];
						rowTemp_2[j]=j;
					}
				}
			}

			/* select computer bingo number */
			System.out.print("com 璋濠 殮溘 : ");
//			comNum=input.nextInt();			// 闡У攪 綵堅 璋濠 殮溘
			comNum=(int)(Math.random()*randomNum)+1;
			
			for(int i=0; i<randomNumCom.length; i++)
			{
				if(comNum==randomNumCom[i])
					break;
				
				if(i==(randomNumCom.length)-1)
				{
					comNum=(int)(Math.random()*randomNum)+1;
					i=0;
				}
			}
///////////////////////////////////////////////////////////////////////////////////////////			
			System.out.println(comNum);
			
			for(int i=0; i<randomNumCom.length; i++)
			{
				if(randomNumUser[i]==comNum)
					randomNumUser[i]=0;
				
				if(randomNumCom[i]==comNum)
					randomNumCom[i]=0;
			}
			
			bingoCountUser=0;	// 嶸盪 綵堅 蟾晦��
			bingoCountCom=0;	// 闡У攪 綵堅 蟾晦��

			// user bingoCount
			for(int i=0; i<randomNumUser.length/5; i++)
			{
				for(int j=0; j<randomNumUser.length/5; j++)	// 陛煎 綵堅 �挫�
				{
					if(randomNumUser[i*5+j]==0)
						rowCount++;
				}
				if(rowCount==5)
					bingoCountUser++;

				for(int j=0; j<randomNumUser.length/5; j++)	// 撮煎 綵堅 �挫�
				{
					if(randomNumUser[i+j*5]==0)
						verCount++;
				}
				if(verCount==5)
					bingoCountUser++;
				
				if(randomNumUser[i*6]==0)		// 渠陝摹 綵堅 �挫�(謝->辦, 0->24)
					diagonal1++;
				
				if(diagonal1==5)
					bingoCountUser++;

				if(randomNumUser[(i+1)*4]==0) 	// 渠陝摹 綵堅 �挫�(辦->謝, 4->20)
					diagonal2++;
				
				if(diagonal2==5)
					bingoCountUser++;

				 rowCount=0;
				 verCount=0;				 
			}
			diagonal1=0;
			diagonal2=0;
			
			// computer bingoCount
			for(int i=0; i<randomNumCom.length/5; i++)
			{
				for(int j=0; j<randomNumCom.length/5; j++)	// 陛煎 綵堅 �挫�
				{
					if(randomNumCom[i*5+j]==0)
					{
						rowCount++;
						rowBingo[i]++;					
					}
				}
				if(rowCount==5)
					bingoCountCom++;

				for(int j=0; j<randomNumCom.length/5; j++)	// 撮煎 綵堅 �挫�
				{
					if(randomNumCom[i+j*5]==0)
					{
						verCount++;
						verBingo[j]++;											
					}
				}
				if(verCount==5)
					bingoCountCom++;
				
				if(randomNumCom[i*6]==0)		// 渠陝摹 綵堅 �挫�(謝->辦, 0->24)
				{
					diagonal1++;
					diaBingo[0]++;
				}
				
				if(diagonal1==5)
					bingoCountCom++;

				if(randomNumCom[(i+1)*4]==0) 	// 渠陝摹 綵堅 �挫�(辦->謝, 4->20)
				{
					diagonal2++;
					diaBingo[1]++;
				}
				
				if(diagonal2==5)
					bingoCountCom++;
				
				 rowCount=0;
				 verCount=0;
			}
			diagonal1=0;	// 渠陝摹 綵堅 蟾晦��
			diagonal2=0;
				
			System.out.println("\n");	
			System.out.println("--     user bingo : "+ bingoCountUser +"\n-- computer bingo : "+bingoCountCom);

		}
		
	}

}
