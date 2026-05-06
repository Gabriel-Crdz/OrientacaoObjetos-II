CREATE TABLE cartao(
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    num_cartao VARCHAR(20) NOT NULL,
    nome_titular VARCHAR(80) NOT NULL,
    agencia VARCHAR(20),
    bandeira VARCHAR(20),
    cvv VARCHAR(3) NOT NULL,
    data_validade DATE NOT NULL,
    limite_total DECIMAL(10,2) NOT NULL,
    fatura_atual DECIMAL(10,2) NOT NULL
);

CREATE TABLE cartao(
    codigo SERIAL PRIMARY KEY,
    num_cartao VARCHAR(20) NOT NULL,
    nome_titular VARCHAR(100) NOT NULL,
    agencia VARCHAR(20),
    bandeira VARCHAR(20),
    cvv VARCHAR(3) NOT NULL,
    data_validade DATE NOT NULL,
    limite_total NUMERIC(10,2) NOT NULL,
    fatura_atual NUMERIC(10,2) NOT NULL
);

INSERT INTO cartao(
    num_cartao,
    nome_titular,
    agencia,
    bandeira,
    cvv,
    data_validade,
    limite_total,
    fatura_atual
) 
VALUES
('4532019823745612', 'Maria Antonieta', 'Bradesco', 'Visa', '321', '2029-08-01', 4500.00, 1200.50),
('5503984720193847', 'Silvio Santos', 'Itau', 'Mastercard', '456', '2030-05-01', 8000.00, 2350.75),
('6011345678901234', 'Fausto Silva', 'Nubank', 'Discover', '789', '2028-11-01', 3000.00, 980.00),
('4111111111111114', 'Nicolau II Romanov', 'Bradesco', 'Visa', '159', '2031-01-01', 10000.00, 5400.20),
('5200828282828210', 'Maria Leopoldina da Áustria', 'Santander', 'Mastercard', '753', '2027-06-01', 2500.00, 400.00),
('378282246310005', 'Isaac Newton', 'C6 Bank', 'Amex', '852', '2029-09-01', 12000.00, 7200.99),
('6011000990139424', 'Michelangelo di Lodovico', 'PicPay', 'Discover', '951', '2028-03-01', 6000.00, 3100.10),
('4222222222222', 'Rafael Sanzio', 'Itau', 'Visa', '147', '2032-07-01', 2000.00, 150.00),
('5555555555554444', 'Alcione Bennachio', 'Itau', 'Mastercard', '258', '2030-10-01', 7000.00, 2750.45),
('4012888888881881', 'Donatelo di Niccoló', 'Bradesco', 'Visa', '369', '2027-12-01', 3500.00, 890.60),
('5105105105105100', 'Leonardo da Vinci', 'Nubank', 'Mastercard', '741', '2029-04-01', 9000.00, 4999.99),
('3530111333300000', 'Vinicius Rambo', 'Santander
', 'Elo', '963', '2031-02-01', 4000.00, 2100.30);