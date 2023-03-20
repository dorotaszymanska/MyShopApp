package com.app1.demo.shop.sklepinternetowy.service;

import com.app1.demo.shop.sklepinternetowy.exception.AuctionServiceException;
import com.app1.demo.shop.sklepinternetowy.request.AuctionCreationRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuctionService {

    public void createAuction(AuctionCreationRequest request) {

            if (request.getName().isBlank()) {
                throw new AuctionServiceException("Nie uzupełniono nazwy!!!");
            } else if (request.getPrice() <= 0) {
                throw new AuctionServiceException("Cena musi być większa od 0 !!!");
            }else if(request.getAmount() <=0){
                throw new AuctionServiceException("Ilość musi być większa od 0 !!!");

            }else{
            System.out.println("Wszystko ok, dodaję");
            }
            //dodawanie do bazy danych
        }
    }

