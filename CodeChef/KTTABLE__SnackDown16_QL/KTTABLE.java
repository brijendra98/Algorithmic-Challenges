import java.io.*;
 
class JavaApplication6
{
  
    public static int prg(String a[], String b[])
    {
        
        int x=0;
        int pt=0;
        
        for(int i=0;i<a.length;i++)
        {
            int m=Integer.parseInt(a[i])-pt,n=Integer.parseInt(b[i]);
            if(m>=n)
            {
                x++;
            }
            pt=Integer.parseInt(a[i]);
        }
        
        
        
        
        return x;
    }
    
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        if(tc<=10)
        {
            int ari[]=new int[tc];
            String tm[]=new String[tc];
            String tp[]=new String[tc];
            for (int i = 0; i < tc; i++) 
            {
                ari[i] = Integer.parseInt(br.readLine());
                tm[i] = br.readLine();
                tp[i]=br.readLine();
            }
            
            for(int i=0;i<tc;i++)
                System.out.println(prg((tm[i].split(" ")), (tp[i].split(" "))));
            
                
            
        }
    }
} 
