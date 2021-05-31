package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Ali {


    public class Ticket{
        public String from;
        public String to;
        public String time;
        public double price;
    }

    public class TicketManager{

        private List<Ticket> tickets = new ArrayList<Ticket>();

        // 单张票组合
        public List<Ticket> search(String from, String to, String time){

            Integer sum = null;
            List<Ticket> result = new ArrayList<Ticket>();
            for (Ticket ticket : tickets) {
                int tSum = 0;
                String tFrom = from;
                List<Ticket> tList = new ArrayList<Ticket>();
//                String tTo = to;
//                String tTime = time;
                if(ticket.from.equals(tFrom)){//  && ticket.time > tTime
                    tSum += ticket.price;
                    tFrom = ticket.to;
//                    tTime = ticket.time;
                    tList.add(ticket);

                }
                if(ticket.to.equals(to)){
                    if(sum == null || sum > tSum){
                        sum = tSum;
                        result = tList;
                    }
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {

    }
}
