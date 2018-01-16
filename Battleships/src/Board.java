import java.awt.*;
import java.util.Scanner;

public class Board {
    private int board[][];


    public Board()
    {
        board = new int[10][10];
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                board[i][j] = 0;
            }
        }
    }

    public void placeShips()
    {
        Scanner scan = new Scanner(System.in);
        Point start, current, end = null;
        boolean wasBroke=false;

        //1 tile ships
        for(int i=0;i<4;i++)
        {
            System.out.println("Place 1-point ship. Set your [row] and [column]");
            start = new Point(scan.nextInt()-1, scan.nextInt()-1);
            if(start.x > -1 && start.x < 10 && start.y > -1 && start.y < 10)
            {
                if (isEmpty(start) && !isNeighbouring(start))
                {
                    throwShipOnBoard(start);
                }
                else
                {
                    System.out.println("Invalid coordinates.");
                    i--;
                }
            }
            else
            {
                System.out.println("Invalid coordinates.");
                i--;
            }
            drawBoard();
        }

        //2 tile ships
        for(int i=0;i<3;i++)
        {
            System.out.println("Place 2-point ship. Set [row] and [column] of start point");
            start = new Point(scan.nextInt()-1, scan.nextInt()-1);
            System.out.println("Place 2-point ship. Set [row] and [column] of end point");
            end = new Point(scan.nextInt()-1, scan.nextInt()-1);
            if(start.x > -1 && start.x < 10 && start.y > -1 && start.y < 10
                    && end.x > - 1 && end.x < 10 && end.y > - 1 && end.y < 10)
            {
                if(start.x == end.x)
                {
                    if(start.y - end.y == 1) //start.y - end.y = 1
                    {
                        for(int j = start.y; j >= end.y; j--)
                        {
                            current = new Point(start.x, j);
                            if(!isEmpty(current) || isNeighbouring(current))
                            {
                                System.out.println("Invalid coordinates.");
                                i--;
                                wasBroke = true;
                                break;
                            }
                        }
                        if(!wasBroke)
                        {
                            for(int j = start.y; j >= end.y; j--)
                            {
                                current = new Point(start.x, j);
                                throwShipOnBoard(current);
                            }
                        }
                    }
                    else if(start.y - end.y == -1)
                    {
                        for(int j = start.y; j <= end.y; j++)
                        {
                            current = new Point(start.x, j);
                            if(!isEmpty(current) || isNeighbouring(current))
                            {
                                System.out.println("Invalid coordinates.");
                                i--;
                                wasBroke = true;
                                break;
                            }
                        }
                        if(!wasBroke)
                        {
                            for(int j = start.y; j <= end.y; j++)
                            {
                                current = new Point(start.x, j);
                                throwShipOnBoard(current);
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Invalid coordinates.");
                        i--;
                    }
                }

                else if(start.y == end.y)
                {
                    if(start.x - end.x == 1)
                    {
                        for(int j = start.x; j >= end.x; j--)
                        {
                            current = new Point(j, start.y);
                            if(!isEmpty(current) || isNeighbouring(current))
                            {
                                System.out.println("Invalid coordinates.");
                                i--;
                                wasBroke = true;
                                break;
                            }
                        }
                        if(!wasBroke)
                        {
                            for(int j = start.x; j >= end.x; j--)
                            {
                                current = new Point(j, start.y);
                                throwShipOnBoard(current);
                            }
                        }

                    }
                    else if(start.x - end.x == -1)
                    {
                        for(int j = start.x; j <= end.x; j++)
                        {
                            current = new Point(j, start.y);
                            if(!isEmpty(current) || isNeighbouring(current))
                            {
                                System.out.println("Invalid coordinates.");
                                i--;
                                wasBroke = true;
                                break;
                            }
                        }
                        if(!wasBroke)
                        {
                            for(int j = start.x; j <= end.x; j++)
                            {
                                current = new Point(j, start.y);
                                throwShipOnBoard(current);
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Invalid coordinates.");
                        i--;
                    }
                }
            }
            else
            {
                System.out.println("Invalid coordinates.");
                i--;
            }
            wasBroke = false;
        drawBoard();
        }

        //3 tile ships
        for(int i=0;i<2;i++)
        {
            System.out.println("Place 3-point ship. Set [row] and [column] of start point");
            start = new Point(scan.nextInt()-1, scan.nextInt()-1);
            System.out.println("Place 3-point ship. Set [row] and [column] of end point");
            end = new Point(scan.nextInt()-1, scan.nextInt()-1);
            if(start.x > -1 && start.x < 10 && start.y > -1 && start.y < 10
                    && end.x > - 1 && end.x < 10 && end.y > - 1 && end.y < 10)
            {
                if(start.x == end.x)
                {
                    if(start.y - end.y == 2) //start.y - end.y = 1
                    {
                        for(int j = start.y; j >= end.y; j--)
                        {
                            current = new Point(start.x, j);
                            if(!isEmpty(current) || isNeighbouring(current))
                            {
                                System.out.println("Invalid coordinates.");
                                i--;
                                wasBroke = true;
                                break;
                            }
                        }
                        if(!wasBroke)
                        {
                            for(int j = start.y; j >= end.y; j--)
                            {
                                current = new Point(start.x, j);
                                throwShipOnBoard(current);
                            }
                        }
                    }
                    else if(start.y - end.y == -2)
                    {
                        for(int j = start.y; j <= end.y; j++)
                        {
                            current = new Point(start.x, j);
                            if(!isEmpty(current) || isNeighbouring(current))
                            {
                                System.out.println("Invalid coordinates.");
                                i--;
                                wasBroke = true;
                                break;
                            }
                        }
                        if(!wasBroke)
                        {
                            for(int j = start.y; j <= end.y; j++)
                            {
                                current = new Point(start.x, j);
                                throwShipOnBoard(current);
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Invalid coordinates.");
                        i--;
                    }
                }

                else if(start.y == end.y)
                {
                    if(start.x - end.x == 2)
                    {
                        for(int j = start.x; j >= end.x; j--)
                        {
                            current = new Point(j, start.y);
                            if(!isEmpty(current) || isNeighbouring(current))
                            {
                                System.out.println("Invalid coordinates.");
                                i--;
                                wasBroke = true;
                                break;
                            }
                        }
                        if(!wasBroke)
                        {
                            for(int j = start.x; j >= end.x; j--)
                            {
                                current = new Point(j, start.y);
                                throwShipOnBoard(current);
                            }
                        }

                    }
                    else if(start.x - end.x == -2)
                    {
                        for(int j = start.x; j <= end.x; j++)
                        {
                            current = new Point(j, start.y);
                            if(!isEmpty(current) || isNeighbouring(current))
                            {
                                System.out.println("Invalid coordinates.");
                                i--;
                                wasBroke = true;
                                break;
                            }
                        }
                        if(!wasBroke)
                        {
                            for(int j = start.x; j <= end.x; j++)
                            {
                                current = new Point(j, start.y);
                                throwShipOnBoard(current);
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Invalid coordinates.");
                        i--;
                    }
                }
                else
                {
                    System.out.println("Invalid coordinates.");
                    i--;
                }
            }
            else
            {
                System.out.println("Invalid coordinates.");
                i--;
            }
            wasBroke = false;
            drawBoard();
        }

        //4 tiles ship
        for(int i=0;i<1;i++)
        {
            System.out.println("Place 4-point ship. Set [row] and [column] of start point");
            start = new Point(scan.nextInt()-1, scan.nextInt()-1);
            System.out.println("Place 4-point ship. Set [row] and [column] of end point");
            end = new Point(scan.nextInt()-1, scan.nextInt()-1);

            if(start.x > -1 && start.x < 10 && start.y > -1 && start.y < 10
               && end.x > - 1 && end.x < 10 && end.y > - 1 && end.y < 10)
            {
                if(start.x == end.x)
                {
                    if(start.y - end.y == 3) //start.y - end.y = 1
                    {
                        for(int j = start.y; j >= end.y; j--)
                        {
                            current = new Point(start.x, j);
                            if(!isEmpty(current) || isNeighbouring(current))
                            {
                                System.out.println("Invalid coordinates.");
                                i--;
                                wasBroke = true;
                                break;
                            }
                        }
                        if(!wasBroke)
                        {
                            for(int j = start.y; j >= end.y; j--)
                            {
                                current = new Point(start.x, j);
                                throwShipOnBoard(current);
                            }
                        }
                    }
                    else if(start.y - end.y == -3)
                    {
                        for(int j = start.y; j <= end.y; j++)
                        {
                            current = new Point(start.x, j);
                            if(!isEmpty(current) || isNeighbouring(current))
                            {
                                System.out.println("Invalid coordinates.");
                                i--;
                                wasBroke = true;
                                break;
                            }
                        }
                        if(!wasBroke)
                        {
                            for(int j = start.y; j <= end.y; j++)
                            {
                                current = new Point(start.x, j);
                                throwShipOnBoard(current);
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Invalid coordinates.");
                        i--;
                    }
                }

                else if(start.y == end.y)
                {
                    if(start.x - end.x == 3)
                    {
                        for(int j = start.x; j >= end.x; j--)
                        {
                            current = new Point(j, start.y);
                            if(!isEmpty(current) || isNeighbouring(current))
                            {
                                System.out.println("Invalid coordinates.");
                                i--;
                                wasBroke = true;
                                break;
                            }
                        }
                        if(!wasBroke)
                        {
                            for(int j = start.x; j >= end.x; j--)
                            {
                                current = new Point(j, start.y);
                                throwShipOnBoard(current);
                            }
                        }

                    }
                    else if(start.x - end.x == -3)
                    {
                        for(int j = start.x; j <= end.x; j++)
                        {
                            current = new Point(j, start.y);
                            if(!isEmpty(current) || isNeighbouring(current))
                            {
                                System.out.println("Invalid coordinates.");
                                i--;
                                wasBroke = true;
                                break;
                            }
                        }
                        if(!wasBroke)
                        {
                            for(int j = start.x; j <= end.x; j++)
                            {
                                current = new Point(j, start.y);
                                throwShipOnBoard(current);
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Invalid coordinates.");
                        i--;
                    }
                }
            }
            else
            {
                System.out.println("Invalid coordinates.");
                i--;
            }
            wasBroke = false;
            drawBoard();
        }

    }





    public boolean isEmpty(Point place)
    {
        if(board[(int)place.getX()][(int)place.getY()] == 0)
            return true;
        else
            return false;
    }



    public boolean isNeighbouring(Point place)
    {
        //case 1 -> x=0 && y=0
        if((int)place.getX() == 0 && (int)place.getY() == 0)
        {
            for(int i = (int)place.getX();i<=(int)place.getX()+1;i++)
            {
                for(int j = (int)place.getY();j<=(int)place.getY()+1;j++)
                {
                    if(!isEmpty(new Point(i,j)))
                    {
                        return true;
                    }
                }
            }
        }

        //case 2 -> x=0 && y=9
        else if((int)place.getX() == 0 && (int)place.getY() == 9)
        {
            for(int i = (int)place.getX();i<=(int)place.getX()+1;i++)
            {
                for(int j = (int)place.getY()-1;j<=(int)place.getY();j++)
                {
                    if(!isEmpty(new Point(i,j)))
                    {
                        return true;
                    }
                }
            }
        }

        //case 3 -> x=9 && y=0
        else if((int)place.getX() == 9 && (int)place.getY() == 0)
        {
            for(int i = (int)place.getX()-1;i<=(int)place.getX();i++)
            {
                for(int j = (int)place.getY();j<=(int)place.getY()+1;j++)
                {
                    if(!isEmpty(new Point(i,j)))
                    {
                        return true;
                    }
                }
            }
        }

        //case 4 -> x=9 && y=9
        else if((int)place.getX() == 9 && (int)place.getY() == 9)
        {
            for(int i = (int)place.getX()-1;i<=(int)place.getX();i++)
            {
                for(int j = (int)place.getY()-1;j<=(int)place.getY();j++)
                {
                    if(!isEmpty(new Point(i,j)))
                    {
                        return true;
                    }
                }
            }
        }

        //case 5 -> x=0 && 0<y<9
        else if((int)place.getX() == 0 && (int)place.getY() > 0 && (int)place.getY() < 9)
        {
            for(int i = (int)place.getX();i<=(int)place.getX()+1;i++)
            {
                for(int j = (int)place.getY()-1;j<=(int)place.getY()+1;j++)
                {
                    if(!isEmpty(new Point(i,j)))
                    {
                        return true;
                    }
                }
            }
        }
        //case 6 x=9 && 0<y<9
        else if((int)place.getX() == 9 && (int)place.getY() > 0 && (int)place.getY() < 9)
        {
            for(int i = (int)place.getX()-1;i<=(int)place.getX();i++)
            {
                for(int j = (int)place.getY()-1;j<=(int)place.getY()+1;j++)
                {
                    if(!isEmpty(new Point(i,j)))
                    {
                        return true;
                    }
                }
            }
        }

        //case 7 -> 0<x<9 && y=0
        else if((int)place.getX() > 0 && (int)place.getX() < 9 && (int)place.getY() == 0)
        {
            for(int i = (int)place.getX()-1;i<=(int)place.getX()+1;i++)
            {
                for(int j = (int)place.getY();j<=(int)place.getY()+1;j++)
                {
                    if(!isEmpty(new Point(i,j)))
                    {
                        return true;
                    }
                }
            }
        }

        //case 8 -> 0<x<9 && y=9
        else if((int)place.getX() > 0 && (int)place.getX() < 9 && (int)place.getY() == 9)
        {
            for(int i = (int)place.getX()-1;i<=(int)place.getX()+1;i++)
            {
                for(int j = (int)place.getY()-1;j<=(int)place.getY();j++)
                {
                    if(!isEmpty(new Point(i,j)))
                    {
                        return true;
                    }
                }
            }
        }

        //case 9 -> 0<x<9 && 0<y<9
        else
        {
            for(int i = (int)place.getX()-1;i<=(int)place.getX()+1;i++)
            {
                for(int j = (int)place.getY()-1;j<=(int)place.getY()+1;j++)
                {
                    if(!isEmpty(new Point(i,j)))
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void throwShipOnBoard(Point current)
    {
            board[(int)current.getX()][(int)current.getY()] = 1;
    }

    public void drawBoard()
    {
        System.out.println("\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ");
        for(int i=0;i<10;i++)
        {
            System.out.print(i + 1 +"\t");
            for(int j=0;j<10;j++)
            {
                if(board[i][j]==1)
                    System.out.print("x\t");
                else
                    System.out.print("0\t");

            }
            System.out.println("\n");
        }
    }

    public void drawBothBoards(Board p2)
    {
        System.out.println("\tPLAYER 1");
        System.out.println("\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ");
        for(int i=0;i<10;i++)
        {
            System.out.print(i + 1 +"\t");
            for(int j=0;j<10;j++)
            {
                if(board[i][j]==1)
                    System.out.print("0\t");
                else if(board[i][j]==-1)
                    System.out.print("-\t");
                else if(board[i][j]==-2)
                    System.out.print("*\t");
                else
                    System.out.print("0\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");

        System.out.println("\tPLAYER 2");
        System.out.println("\tA\tB\tC\tD\tE\tF\tG\tH\tI\tJ");
        for(int i=0;i<10;i++)
        {
            System.out.print(i + 1 +"\t");
            for(int j=0;j<10;j++)
            {
                if(p2.board[i][j]==1)
                    System.out.print("0\t");
                else if(p2.board[i][j]==-1)
                    System.out.print("-\t");
                else if(p2.board[i][j]==-2)
                    System.out.print("*\t");
                else
                    System.out.print("0\t");

            }
            System.out.println("\n");
        }
    }

    public int getHitCount()
    {
        int count=0;
        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                if(board[i][j]==1)
                {
                    count++;
                }
            }
        }
        return count;
    }


    public void erase(Point place, int code)
    {
        board[place.x][place.y] = code;
    }

    public boolean canIHit(Point place)
    {
        if(board[(int)place.getX()][(int)place.getY()] == -1 || board[(int)place.getX()][(int)place.getY()] == -2)
            return false;
        else
            return true;
    }
}
