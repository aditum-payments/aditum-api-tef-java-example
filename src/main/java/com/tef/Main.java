package com.tef;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.tef.domain.InitRequest;
import com.tef.domain.PaymentRequest;
import com.tef.domain.PaymentResponse;
import com.tef.domain.PaymentStatus;
import com.tef.domain.PinpadMessages;
import com.tef.servico.ServicoTEF;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner entradaDados = new Scanner(System.in);
        Scanner entradaDadosString = new Scanner(System.in);

        do {

            System.out.println("\n\n*---------------------------*");
            System.out.println("| Bem-vindo ao TEF Aditum   |");
            System.out.println("|---------------------------|");
            System.out.println("| 1 - Init                  |");
            System.out.println("| 2 - Cobrança              |");
            System.out.println("| 3 - Confirmar             |");
            System.out.println("| 4 - Cancelar              |");
            System.out.println("| 5 - Reverter              |");
            System.out.println("| 6 - Transações Pendentes  |");
            System.out.println("| 7 - Display               |");
            System.out.println("*---------------------------*");
            Integer cursor = entradaDados.nextInt();

            switch (cursor) {
                case 1:
                    System.out.println("Digite o merchantToken do estabelecimento que deseja ativar: ");
                    String merchantToken = entradaDadosString.next();
                    System.out.println("Digite o código de ativação do estabelecimento: ");
                    String activationCode = entradaDados.next();
                    PinpadMessages pinpadMessages = new PinpadMessages("Aprovado", "Negado", "Iniciando...", "Enviando...");
                    InitRequest initPinpad = new InitRequest("MyApplication", "1.0.0", activationCode , true, pinpadMessages);
                    ServicoTEF.init(initPinpad, merchantToken);
                    break;
                case 2:
                    System.out.println(
                        "Digite o valor de pagamento sem ponto ou virgula, exemplo : (para 10,00R$) DIGITE => 1000");
                    Integer amountUser = entradaDados.nextInt();
                    System.out.println("\n*-----------------------------------*");
                    System.out.println("| Selecione o método de pagamento   |");
                    System.out.println("|-----------------------------------|");
                    System.out.println("| 1 - DÉBITO                        |");
                    System.out.println("| 2 - CRÉDITO                       |");
                    System.out.println("*-----------------------------------*");
                    Integer cursorPaymentType = entradaDados.nextInt();
                    String paymentTypeUser;
                    // PaymentType paymentTypeUser;

                    switch (cursorPaymentType) {    
                        case 1:
                            paymentTypeUser = "Debit";
                            break;
                        case 2:
                            paymentTypeUser ="Credit";
                            break;
                        default:
                            paymentTypeUser = "None";
                            break;
                    }
                    PaymentRequest authorizationRequestRequest = new PaymentRequest(amountUser, paymentTypeUser, 0);
                    PaymentResponse resultado;
                    do {
                        resultado = ServicoTEF.payment(authorizationRequestRequest);
                        System.out.println("Payment status: " + resultado.getStatus());

                        TimeUnit.MILLISECONDS.sleep(1000);
                    } while (isStatusRepetitivo(resultado));

                    System.out.println(resultado);

                    break;
                case 3:
                    System.out.println("Digite o NSU da transação que deseja confirmar: ");
                    ServicoTEF.confirm(entradaDados.nextInt());
                    break;
                case 4:
                    System.out.println("Digite o NSU da transação que deseja cancelar: ");
                    ServicoTEF.cancelation(entradaDados.nextInt());
                    break;
                case 5:
                    System.out.println("Digite o NSU da transação que deseja reverter: ");
                    ServicoTEF.reversal(entradaDados.next());
                    break;
                case 6:
                    ServicoTEF.getPending();
                    break;
                case 7:
                    System.out.println("Escreva uma mensagem com até 32 caracteres: ");
                    String message = entradaDadosString.nextLine();
                    String messageEncode = URLEncoder.encode(message, StandardCharsets.UTF_8.toString()).replace("+",
                            "%20");
                    ServicoTEF.display(messageEncode);
                    break;
                default:
                    System.out.println("Valor inválido !");
                    break;
            }
        } while (true);
    }
    
    private static boolean isStatusRepetitivo(PaymentResponse paymentResponse) {
        PaymentStatus status = paymentResponse.getStatus();
        return status == PaymentStatus.STARTING_TRANSACTION ||
                status == PaymentStatus.CHECK_CARD_EVENT ||
                status == PaymentStatus.PROCESSING_ONLINE ||
                status == PaymentStatus.FINISHING_TRANSACTION ||
                status == PaymentStatus.GETTING_PIN;
    }

}
