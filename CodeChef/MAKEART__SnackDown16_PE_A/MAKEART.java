import java.io.*;
 
class Art
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        int arr[]= new int[tc];
        int ari[]=new int[tc];
        for(int i=0;i<tc;i++)
        {
            ari[i] = Integer.parseInt(br.readLine());
            String arr1[]= (br.readLine()).split(" ");
            
            if(prg(arr1))
                System.out.println("Yes");
            else
                System.out.println("No");
                
        }
    
    }
    
    
    public static boolean prg(String arr[])
    {
        int a[]=new int[arr.length];
        int b[]=new int[arr.length];
        
        boolean check=true;
        
        for(int i=0;i<arr.length;i++)
        {
            a[i]=Integer.parseInt(arr[i]);
        }
        
        for(int i=0;i<(b.length-2);i++)
        {
            if(a[i]!=b[i])
            {
                b[i]=a[i];
                b[i+1]=a[i];
                b[i+2]=a[i];
            }
        }
        
        for(int i=0;i<arr.length;i++)
        {
            if(a[i]!=b[i])
                check=false;
        }
        
        boolean c1=true;
        if(check==false)
        {
          for(int i=b.length-1;i>1;i--)
          {
            if(a[i]!=b[i])
            {
                b[i]=a[i];
                b[i-1]=a[i];
                b[i-2]=a[i];
            }
          }  
        
        
        
        for(int i=0;i<arr.length;i++)
        {
            if(a[i]!=b[i])
                c1=false;
        }
        }
        if(c1||check)
            return true;
        else
            return false;
    }
        
    } 
