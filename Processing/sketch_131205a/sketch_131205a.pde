  
  //import java.util.Color;
  
  public static int julia(ComplexNumber z0, ComplexNumber c, int max, int t) {
          if (t < max) {
              if (z0.magnitude() > Math.sqrt(10.0)) return t;
              z0 = z0.pow(2).add(c);
          }
          else if (t>=max) return max;
          t++;
         return julia(z0, c, max, t);
      }
      


    // return number of iterations to check if c = a + ib is in Mandelbrot set
    public static int mand(ComplexNumber z0, int max) {
        ComplexNumber z = z0;
        for (int t = 0; t < max; t++) {
            if (z.magnitude() > 2.0) return t;
            z = z.multiply(z).add(z0);
        }
        return max;
    }
    
    
    double lastXC = 0;
    double lastYC = 0;
    double sizeThis =3;
    public PImage draw1(ComplexNumber constant, int mode, double zoom, double xc, double yc, double s){
        //double xc   = -.5;
        //double yc   = 0;
        if (s != 0){sizeThis = s;} 
        
        if (zoom == 1){sizeThis-=0.5;xc = map((float)xc, -2f, 2f, (float)(-sizeThis/3), (float)(sizeThis/3));yc = map((float)yc, -1.5f, 1.5f, (float)(-sizeThis/3), (float)(sizeThis/3));}

        int N   = 800; 
        int M   = 800;  // create N-by-N image
        int max = 255;   // maximum number of iterations

      PImage pic = new PImage(N, M); 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double x0 = xc - sizeThis/2 + sizeThis*i/N;
                double y0 = yc - sizeThis/2 + sizeThis*j/N;
                ComplexNumber z0 = new ComplexNumber(x0, y0);
                int gray;
                if (mode == 1){ gray = max - julia(z0, constant, max, 1);}
                else {gray = max - mand(z0, max);}
                color clr = color(gray, gray, gray);
                color a = color(10, 10, 10);
                color b = color(30, 30, 30);
                color c = color(60, 60, 60);
                color d = color(90, 90, 90);
                color e = color(120, 120, 120);
                color f = color(150, 150, 150);
                color g = color(180, 180, 180);
                color h = color(10, 10, 10);
                color o = color(240, 240, 240);
                color p = color(250, 250, 250);
                 if (gray<210){clr = a;}
                else if (gray<225){clr = b;}
                else if (gray<235){clr = d;}
                else if (gray<240){clr = e;}
                else if (gray<245){clr = f;}
                else if (gray<248){clr = g;}
                else if (gray<251){clr = o;}
                else if (gray <255){clr = p;}
               pic.set(i, N-1-j, clr);
            }
        }
      return pic;
    }
    
    
    
    
    void setup(){
      size(800, 800);
     ComplexNumber num = new ComplexNumber(.897, -1.23);
       image(draw1(num, 2, 0, -.5, 0, 0 ), 0, 0); 
       
        
    }
    ComplexNumber num = new ComplexNumber( map(mouseX, 0, 800, -2, 2), map(mouseY-800, 0, -800, -1.5, 1.5));
    void draw(){
      noStroke();
      rect(90, 90, 250, 15);
      fill(0);
      text(""+ map(mouseX, 0, 800, -2, 2)+ " , " +map(mouseY-800, 0, -800, -1.5, 1.5), 100, 100);
      fill(255,255,255);
      
     
    }
     
    
    void mouseClicked(){
        if (mouseButton == LEFT) {
          num = new ComplexNumber( map(mouseX, 0, 800, -2, 2), map(mouseY-800, 0, -800, -1.5, 1.5));
       image(draw1(num, 1, 0, 0, 0, 4 ), 0, 0); 
       //image(draw1(num, 2, 1, map(mouseX, 0, 800, -2, 2),map(mouseY-800, 0, -800, -1.5, 1.5) ), 0, 0); 
        }
        else if (mouseButton == RIGHT){

           image(draw1(num, 1, 1, 0, 0, 0 ), 0, 0); 
        }
       
        
    }
    
    void keyPressed(){
      
          image(draw1(num, 1, 1, 0, 0, 0 ), 0, 0); 
        }
  
   
      
      
      
      
