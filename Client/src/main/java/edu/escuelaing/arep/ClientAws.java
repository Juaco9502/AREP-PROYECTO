package edu.escuelaing.arep;

/**
 * Hello world!
 *
 */
public class ClientAws 
{
     public static int clients = 2000;
    public static String url  = "http://52.87.176.226:4567/ordenar?cadena=";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        ClientThread[] threads = new ClientThread[clients];

        for (int i = 0; i < clients; i++) {
            threads[i] = new ClientThread(url);
        }
        for (int i = 0; i < clients; i++) {
            threads[i].start();
        }
        for (int i = 0; i < clients; i++) {
            threads[i].join();
        }
        System.out.println("Request finish");
    }
}
