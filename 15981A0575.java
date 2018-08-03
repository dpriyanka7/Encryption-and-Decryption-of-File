import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.*;
import java.io.*;
import java.lang.*;

class CipherMessage
{
    int readCipherText(String f)
    {
     try
    {
     int i,value,len,j,k;
     java.util.Scanner s = new java.util.Scanner(new java.io.File(f));
     while(s.hasNext())
          {
            value=0;
            String word = s.next();
            String[] result = word.split("\\|");
            len=result[2].length();
            j=Integer.parseInt(result[0]);
            if(j==len)
            {
             String w=result[2];
             for(i=0;i<w.length();i++)
               value+=w.charAt(i);
             k=Integer.parseInt(result[1]);
             if(value!=k)
             {
               System.out.println("Invalid checksum; got "+value+", expected "+result[1]);
               return 0;
             }
            }
            else
            {
             System.out.println("Illegal input file format");
             return 0;
            }
          }
      }
      catch(Exception e)
      {
      }
     return 1;
    }
    int readClearText(String f)
    {
     try
    {
     int i,value,len,j,k;
     java.util.Scanner s = new java.util.Scanner(new java.io.File(f));
     while(s.hasNext())
          {
            value=0;
            String word = s.next();
            String[] result = word.split("\\|");
            len=result[2].length();
            j=Integer.parseInt(result[0]);
            if(j==len)
            {
             String w=result[2];
             for(i=0;i<w.length();i++)
               value+=w.charAt(i);
             k=Integer.parseInt(result[1]);
             if(value!=k)
             {
               System.out.println("Invalid checksum; got "+value+", expected "+result[1]);
               return 0;
             }
            }
            else
            {
             System.out.println("Illegal input file format");
             return 0;
            }
          }
      }
      catch(Exception e)
      {
      }
     return 1;
    }
    void writeCipherText(String f)
    {
      try
    {
     int i,value,len,j,k;
     java.util.Scanner s = new java.util.Scanner(new java.io.File(f));
     while(s.hasNext())
          {
            value=0;
            String word = s.next();
            String[] result = word.split("\\|");
            len=result[2].length();
            j=Integer.parseInt(result[0]);
            if(j==len)
            {
             String w=result[2];
             for(i=0;i<w.length();i++)
               value+=w.charAt(i);
             k=Integer.parseInt(result[1]);
            }
          }
      }
      catch(Exception e)
      {
      }
    }
    void writeClearText(String f)
    {
  try
    {
     int i,value,len,j,k;
     java.util.Scanner s = new java.util.Scanner(new java.io.File(f));
     while(s.hasNext())
          {
            value=0;
            String word = s.next();
            String[] result = word.split("\\|");
            len=result[2].length();
            j=Integer.parseInt(result[0]);
            if(j==len)
            {
             String w=result[2];
             for(i=0;i<w.length();i++)
               value+=w.charAt(i);
             k=Integer.parseInt(result[1]);
            }
          }
      }
      catch(Exception e)
      {
      }
    }
};

class Encrypter
{
    void encrypt(String f1,String f2)
    {
      Scanner s=new Scanner(System.in);
      System.out.println("Method (rev , shift, xor): ");
      String me=s.next();
       if(me.equals("rev"))
        {
	       ReverseEncrypter r=new ReverseEncrypter();
              r.encrypt(f1,f2);
        }
        else if(me.equals("shift"))
        {
           ShiftEncrypter sh=new ShiftEncrypter();
              sh.encrypt(f1,f2);
        }
        else if(me.equals("xor"))
        {
	       XOREncrypter ro=new XOREncrypter();
              ro.encrypt(f1,f2);
        }
    }
    void decrypt(String f1,String f2)
    {
         Scanner s=new Scanner(System.in);
      System.out.println("Method (rev , shift, xor): ");
      String me=s.next();
       if(me.equals("rev"))
        {
	       ReverseEncrypter r=new ReverseEncrypter();
              r.decrypt(f1,f2);
        }
        else if(me.equals("shift"))
        {
           ShiftEncrypter sh=new ShiftEncrypter();
              sh.decrypt(f1,f2);
        }
        else if(me.equals("xor"))
        {
	       XOREncrypter ro=new XOREncrypter();
              ro.decrypt(f1,f2);
        }
    }
     public static void main(String args[]) throws IOException
     {
      int n;
      String c,d;
      FileOutputStream o;
      FileInputStream i;
      Scanner s=new Scanner(System.in);
      System.out.println("Input: ");
      String file1=s.next();
      System.out.println("Output: ");
      String file2=s.next();
      System.out.println("Encrypt (y/n):");
      d=s.next();
      CipherMessage cm=new CipherMessage();
      if(d=="y")
        n=cm.readClearText(file1);
      else
        n=cm.readCipherText(file1);
      if(n==1)
      {
          Encrypter e = new Encrypter();
          if(d=="y")
            e.encrypt(file1,file2);
          else
            e.decrypt(file1,file2);
      }
    }
};

class ReverseEncrypter
{
   void encrypt(String s1,String s2)
   {
    try
    {
      String newLine = System.getProperty("line.separator");
      BufferedReader in = new BufferedReader(new FileReader(s1));
      DataOutputStream dos = new DataOutputStream(new FileOutputStream(s2));
      String line;
      int i=0;
      while ((line = in.readLine()) != null)
      {
        i=0;
        StringBuilder input1 = new StringBuilder();
        input1.append(line);
        input1 = input1.reverse();
         while(i<input1.length())
         {
           dos.write(input1.charAt(i));
           i++;
         }
          dos.writeBytes(newLine);
       }
     }
      catch (Exception e)
      {
      }
   }
   void decrypt(String s1,String s2)
   {
    try
    {
      String newLine = System.getProperty("line.separator");
      BufferedReader in = new BufferedReader(new FileReader(s1));
      DataOutputStream dos = new DataOutputStream(new FileOutputStream(s2));
      String line;
      int i=0;
      while ((line = in.readLine()) != null)
      {
        i=0;
        StringBuilder input1 = new StringBuilder();
        input1.append(line);
        input1 = input1.reverse();
         while(i<input1.length())
         {
           dos.write(input1.charAt(i));
           i++;
         }
          dos.writeBytes(newLine);
       }
     }
      catch (Exception e)
      {
      }
   }
}

class ShiftEncrypter
{
   void encrypt(String s1,String s2)
   {
      int index;
      int a,b;
      char k;
      String newLine = System.getProperty("line.separator");
      Scanner sc=new Scanner(System.in);
      System.out.println("Shift Amount : ");
      index=sc.nextInt();
      FileInputStream in = null;
      try
      {
         in = new FileInputStream(s1);
         DataOutputStream dos = new DataOutputStream(new FileOutputStream(s2));
         int c;
         while ((c = in.read()) != -1)
         {
             if(c=='\n')
              dos.writeBytes(newLine);
             else
             {
              k=(char)(c+(index%128));
              dos.write(k);
             }
         }
      }
      catch(Exception e)
      {
      }
   }
   void decrypt(String s1,String s2)
   {
      int index;
      int a,b;
      char k;
      String newLine = System.getProperty("line.separator");
      Scanner sc=new Scanner(System.in);
      System.out.println("Shift Amount : ");
      index=sc.nextInt();
      FileInputStream in = null;
      try
      {
         in = new FileInputStream(s1);
         DataOutputStream dos = new DataOutputStream(new FileOutputStream(s2));
         int c;
         while ((c = in.read()) != -1)
         {
             if(c=='\n')
              dos.writeBytes(newLine);
             else
             {
              k=(char)(c+(index%128));
              dos.write(k);
             }
         }
      }
      catch(Exception e)
      {
      }
   }
}

class XOREncrypter
{
   void encrypt(String s1,String s2)
   {
        Scanner sc=new Scanner(System.in);
        FileOutputStream out = null;
        System.out.println("Key : ");
        String key=sc.next();
        char c;
        int l=key.length();
        int i=0,j=0;
        try
        {
          java.util.Scanner s = new java.util.Scanner(new java.io.File(s1));
          out = new FileOutputStream(s2);
          while(s.hasNext())
          {
            String word = s.next();
            i=0;
            while(i<word.length())
             {
                j=j%l;
            	c=(char)(word.charAt(i)^key.charAt(j));
           	    out.write(c);
		        out.write('\n');
            	i++;
            	j++;
             }
           }
        }
        catch(Exception e)
        {
        }
   }
   void decrypt(String s1,String s2)
   {
        Scanner sc=new Scanner(System.in);
        FileOutputStream out = null;
        System.out.println("Key : ");
        String key=sc.next();
        char c;
        int l=key.length();
        int i=0,j=0;
        try
        {
          java.util.Scanner s = new java.util.Scanner(new java.io.File(s1));
          out = new FileOutputStream(s2);
          while(s.hasNext())
          {
            String word = s.next();
            i=0;
            while(i<word.length())
             {
                j=j%l;
            	c=(char)(word.charAt(i)^key.charAt(j));
           	    out.write(c);
		        out.write('\n');
            	i++;
            	j++;
             }
           }
        }
        catch(Exception e)
        {
        }
   }
}
