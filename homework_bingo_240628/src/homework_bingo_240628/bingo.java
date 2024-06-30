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
		
		int rowCount=0;		// ���� ���� 
		int verCount=0;		// ���� ����
		int diagonal1=0;	// �밢�� ����
		int diagonal2=0;	// �밢�� ����
		
		int [] rowBingo = new int[5];	// ���� ���� ī��Ʈ		
		int [] verBingo = new int[5];	// ���� ���� ī��Ʈ
		int [] diaBingo = new int[2];	// �밢�� ���� ī��Ʈ
		
		int nextBingoNum=0; 
		
		int row_1=0;
		int row_2=1;
		int row_3=2;
		int row_4=3;
		int row_5=4;
		
		int ver_1=0;
		int ver_2=1;
		int ver_3=2;
		int ver_4=3;
		int ver_5=4;
		
		int dia_1=0;
		int dia_2=1;
		
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
//			bingoCountUser=0;	// ���� ���� �ʱ�ȭ
//			bingoCountCom=0;	// ��ǻ�� ���� �ʱ�ȭ

			System.out.println("  >> user                     computer <<");
			for(int i=0; i<randomNumUser.length/5; i++)
			{
				for(int j=0; j<randomNumUser.length/5; j++)		// print user biongo number
				{
					if(randomNumUser[j+(i*5)]<10)
					 System.out.print("  "+randomNumUser[j+(i*5)]);
					else
					 System.out.print(" "+randomNumUser[j+(i*5)]);
				}
				System.out.print("           ");
				for(int j=0; j<randomNumCom.length/5; j++)		// print computer biongo number
				{
					if(randomNumCom[j+(i*5)]<10)
						 System.out.print("  "+randomNumCom[j+(i*5)]);
						else
						 System.out.print(" "+randomNumCom[j+(i*5)]);
				}
	
				System.out.print("\n");
			}
			
			if(bingoCountUser>=5 || bingoCountCom>=5)
			{
				if(bingoCountUser==5)
					System.out.println(" ***  user �� ***");
	
				else if(bingoCountUser>5)
					System.out.println(" -- user bingo over --");
				
				else if(bingoCountCom==5)
					System.out.println(" *** com �� ***");
	
				else if(bingoCountCom>5)
					System.out.println(" -- com bingo over --");
				
				break;
			}			
			/* select user bingo number */
			System.out.print("user ���� �Է� : ");
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
			System.out.print("com ���� �Է� : ");
//			comNum=input.nextInt();			// ��ǻ�� ���� ���� �Է�
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
			
			bingoCountUser=0;	// ���� ���� �ʱ�ȭ
			bingoCountCom=0;	// ��ǻ�� ���� �ʱ�ȭ

			// user bingoCount
			for(int i=0; i<randomNumUser.length/5; i++)
			{
				for(int j=0; j<randomNumUser.length/5; j++)	// ���� ���� Ȯ��
				{
					if(randomNumUser[i*5+j]==0)
						rowCount++;
				}
				if(rowCount==5)
					bingoCountUser++;

				for(int j=0; j<randomNumUser.length/5; j++)	// ���� ���� Ȯ��
				{
					if(randomNumUser[i+j*5]==0)
						verCount++;
				}
				if(verCount==5)
					bingoCountUser++;
				
				if(randomNumUser[i*6]==0)		// �밢�� ���� Ȯ��(��->��, 0->24)
					diagonal1++;
				
				if(diagonal1==5)
					bingoCountUser++;

				if(randomNumUser[(i+1)*4]==0) 	// �밢�� ���� Ȯ��(��->��, 4->20)
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
				for(int j=0; j<randomNumCom.length/5; j++)	// ���� ���� Ȯ��
				{
					if(randomNumCom[i*5+j]==0)
					{
						rowCount++;
						rowBingo[i]++;					
					}
				}
				if(rowCount==5)
					bingoCountCom++;

				for(int j=0; j<randomNumCom.length/5; j++)	// ���� ���� Ȯ��
				{
					if(randomNumCom[i+j*5]==0)
					{
						verCount++;
						verBingo[j]++;											
					}
				}
				if(verCount==5)
					bingoCountCom++;
				
				if(randomNumCom[i*6]==0)		// �밢�� ���� Ȯ��(��->��, 0->24)
				{
					diagonal1++;
					diaBingo[0]++;
				}
				
				if(diagonal1==5)
					bingoCountCom++;

				if(randomNumCom[(i+1)*4]==0) 	// �밢�� ���� Ȯ��(��->��, 4->20)
				{
					diagonal2++;
					diaBingo[1]++;
				}
				
				if(diagonal2==5)
					bingoCountCom++;
				
				 rowCount=0;
				 verCount=0;
			}
			diagonal1=0;	// �밢�� ���� �ʱ�ȭ
			diagonal2=0;
				
			System.out.println("\n");	
			System.out.println("--     user bingo : "+ bingoCountUser +"\n-- computer bingo : "+bingoCountCom);

		}
		
	}

}
